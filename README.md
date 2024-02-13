# <img src="https://raw.githubusercontent.com/CraftLR/workshop-git/main/src/main/resources/assets/logo.png" alt="class logo" class="logo"/> 

## La Rochelle Software Craftsmenship

* **Auteurs:**

  * [Sébastien NEDJAR](mailto:sebastien.nedjar@univ-amu.fr)

* **Besoin d'aide ?**

  * Consulter et/ou créér des [issues](https://github.com/CraftLR/workshop-git/issues).
  * [Email](mailto:sebastien.nedjar@univ-amu.fr) pour toutes questions autres.


## Aperçu du workshop et objectifs d'apprentissage
L'objectif de ce workshop est de découvrir la programmation multithreads en Java.

Il est conçu pour vous fournir une compréhension des concepts de programmation concurrente, cruciaux pour le développement de logiciels modernes, performants et fiables. Vous poursuivrez entre autre les objectifs suivants :

1. **Comprendre les threads :**
    - Apprendre ce qu'est un thread, comment il fonctionne et comment il peut être utilisé pour exécuter des tâches en parallèle.
2. **Pratiquer la programmation multithread :**
    - Acquérir des compétences pratiques en créant et en gérant des threads.
3. **Explorer la synchronisation :**
    - Comprendre l'importance de la synchronisation pour un accès sûr aux ressources partagées.
4. **Résoudre des problèmes de concurrence :**
    - Apprendre à identifier et à résoudre les problèmes courants en programmation concurrente, comme les deadlocks et la famine.

Le workshop est divisé en plusieurs exercices pratiques, chacun construisant sur les connaissances acquises dans les précédents :

1. **Introduction aux threads :**
    - Comprendre les bases des threads.
2. **Partage de ressources entre threads :**
    - Observer et gérer les conditions de compétition.
3. **Utilisation des verrous pour la synchronisation :**
    - Apprendre à utiliser des verrous pour un accès sécurisé aux ressources.
4. **Synchronisation avec des moniteurs :**
    - Explorer des mécanismes de synchronisation avancés.
5. **Deadlocks et stratégies d'évitement :**
    - Identifier et éviter les deadlocks.
6. **Le dîner des philosophes :**
    - Appliquer les compétences acquises dans un scénario complexe.
7. **Gestion d'un parking avec sémaphores :**
    - Utiliser les sémaphores pour gérer l'accès à des ressources en nombre limité.
8. **Synchronisation de deux threads par rendez-vous :**
    - Apprendre à synchroniser plusieurs threads à un point de rendez-vous.

## Threads et synchronisation

### Création de votre fork

La première chose à faire est de créer un fork de ce dépôt. Pour ce faire, rendez-vous sur le lien suivant :

<https://classroom.github.com/a/GzMN5CJi>

GitHub va vous créer un dépôt contenant un fork de ce dépôt. Vous apparaîtrez automatiquement comme contributeur de ce projet pour y pousser votre travail.

## Exercice 1 : introduction aux threads

Cet exercice est conçu pour vous donner une première expérience pratique de la création et de la gestion de threads.

### Objectif

Votre tâche est de créer un programme simple qui lance plusieurs threads exécutant des tâches différentes en parallèle. Cet exercice vous aidera à comprendre comment les threads fonctionnent indépendamment au sein d'un même programme.

#### Qu'est-ce qu'un thread ?

Un thread, aussi appelé fil d'exécution, est une séquence d'instructions dans un programme qui peut être exécutée indépendamment des autres parties du programme. En informatique, les threads sont les plus petites unités d'exécution qui peuvent être gérées par un planificateur d'opérations, qui fait partie du système d'exploitation.

#### Caractéristiques principales des threads

- **Parallélisme :** Les threads permettent l'exécution parallèle de tâches. Dans un processeur multicœur, plusieurs threads peuvent s'exécuter simultanément sur différents cœurs.
- **Partage de ressources :** Les threads d'un même processus partagent des ressources communes comme la mémoire et les variables. Cela facilite la communication entre les threads mais introduit aussi la nécessité de synchroniser l'accès à ces ressources partagées.
- **Légèreté :** Créer et gérer des threads est généralement moins coûteux en termes de ressources système que de créer et de gérer des processus.

#### Utilisation des threads

Les threads sont utilisés pour réaliser plusieurs tâches simultanément au sein d'une application. Par exemple :

- Dans une application Web, différents threads peuvent gérer simultanément plusieurs requêtes d'utilisateurs.
- Dans une application de bureau, un thread peut gérer l'interface utilisateur pendant qu'un autre effectue des calculs en arrière-plan.

#### Programmation multithread

La programmation multithread implique de créer et de gérer plusieurs threads pour exécuter des tâches en parallèle. Cela peut améliorer considérablement la performance et la réactivité des applications. Toutefois, elle présente des défis :

- **Synchronisation :** Assurer que les threads accèdent de manière cohérente et sûre aux ressources partagées.
- **Deadlocks :** Éviter les situations où plusieurs threads se bloquent mutuellement, attendant des ressources verrouillées par les autres.
- **Famine :** Prévenir les cas où certains threads ne parviennent pas à accéder aux ressources nécessaires.

#### Threads

En Java, les threads peuvent être créés à l'aide de la classe `Thread` et de l'interface `Runnable`. Java fournit également un cadre de travail de concurrence plus abstrait avec le package `java.util.concurrent` qui offre des fonctionnalités avancées pour gérer le multithreading.

### Tâches à réaliser

1. **Créer plusieurs threads :**
    - Écrivez un programme qui crée au moins deux threads.
    - Chaque thread doit exécuter une méthode statique distincte.

2. **Tâches des threads :**
    - Les méthodes exécutées par les threads se contenteront d'afficher un message sur la console.

3. **Observation :**
    - Observez comment les différents threads exécutent leurs tâches en parallèle.

Voici un squelette de base pour votre programme :

https://github.com/CraftLR/workshop-multithreading-java/blob/e2ad580bfa98df991131801cc2604149a13934d7/src/main/java/dev/craftlr/exercice1/Main.java#L3-L40

### Questions de réflexion

- Comment les threads interagissent-ils avec la console ?
- Avez-vous remarqué un ordre d'exécution particulier ou un modèle dans les sorties des threads ?

### Conclusion

Ce premier exercice vous permet de voir concrètement comment les threads peuvent s'exécuter en parallèle, chacun effectuant ses propres opérations de manière indépendante.

## Exercice 2 : Partage de Ressources entre Threads

### Objectif

Dans cet exercice, vous allez explorer le comportement des threads lorsqu'ils accèdent simultanément à une ressource partagée. Vous comprendrez concrètement ce qu'est une condition de compétition (race condition) et comment elle peut affecter le comportement d'un programme.

### Contexte

Lorsque plusieurs threads accèdent et modifient une même ressource (par exemple, une variable ou une structure de données), cela peut mener à des incohérences et des bugs difficiles à détecter si ces accès ne sont pas correctement gérés. C'est ce que l'on appelle une "condition de compétition".

### Tâches à réaliser

1. **Création d'une ressource partagée :**
    - Définissez une variable partagée, par exemple un entier ou une liste, accessible par plusieurs threads.
2. **Modification concurrente :**
    - Créez plusieurs threads (au moins deux) qui modifient cette variable partagée. Par exemple, chaque thread peut incrémenter une variable partagée un certain nombre de fois.
3. **Observation des résultats :**
    - Après l'exécution des threads, examinez la valeur finale de la variable partagée. Est-elle celle attendue ? Si non, pouvez-vous expliquer pourquoi ?

Voici un exemple de code pour démarrer :

https://github.com/CraftLR/workshop-multithreading-java/blob/e2ad580bfa98df991131801cc2604149a13934d7/src/main/java/dev/craftlr/exercice2/Main.java#L3-L28

### Questions de réflexion

- Après avoir exécuté le programme plusieurs fois, observez-vous des variations dans la valeur finale de `variablePartagee` ? Pourquoi ?
- Comment expliquez-vous ce comportement ?

### Conclusion

Cette activité vise à illustrer l'importance de la synchronisation dans les programmes multithreads. Les variations inattendues dans les résultats sont dues à des accès concurrents non synchronisés à la même ressource, menant à des conditions de compétition. Dans le prochain exercice, vous apprendrez comment résoudre ce problème.

## Exercice 3 : Utilisation de `synchronized` pour la synchronisation

### Objectif

Cet exercice vise à apprendre à utiliser le mot-clé `synchronized` pour gérer l'accès concurrent à des ressources partagées et résoudre les problèmes de conditions de compétition rencontrés dans l'exercice précédent.

### Contexte

En Java, le mot-clé `synchronized` est un moyen simple et efficace de garantir que seul un thread à la fois peut exécuter un bloc de code donné ou accéder à une méthode d'un objet. Cela permet de prévenir les conditions de compétition lorsque plusieurs threads accèdent et modifient une même ressource.

#### Qu'est-ce que `synchronized`?

`Synchronized` est un mécanisme de synchronisation utilisé pour contrôler l'accès aux ressources partagées dans un environnement multithread. Il garantit que seulement un thread à la fois peut exécuter un bloc de code spécifique ou accéder à une méthode synchronisée, empêchant ainsi les conditions de compétition et les incohérences de données.

#### Fonctionnement de `synchronized`

Lorsqu'un thread entre dans un bloc de code `synchronized` ou une méthode `synchronized` d'un objet, il acquiert un verrou sur cet objet. Si un autre thread tente d'entrer dans un bloc ou une méthode `synchronized` sur le même objet, il doit attendre que le premier thread libère le verrou.

#### Syntaxe de Base

**Bloc Synchronized :**

```java
synchronized (verrou) {
    // Section critique: code qui accède à des ressources partagées
}
```

**Méthode Synchronized :**

```java
public synchronized void methodeCritique() {
    // Code critique ici
}
```

Ici, `verrou` est un objet sur lequel le verrou est placé. La section critique est le code qui nécessite un accès exclusif.

#### Avantages de `synchronized`

- **Simplicité :** L'utilisation de `synchronized` est simple à comprendre et met en œuvre un modèle de verrouillage sûr.
- **Sécurité :** Il aide à éviter les conditions de compétition, garantissant la cohérence des données partagées.
- **Gestion automatique des verrous :** Le verrou est automatiquement acquis et libéré par le runtime Java, ce qui réduit le risque d'erreurs.

#### Considérations importantes

- **Choix de l'objet de verrouillage :** Pour les blocs synchronisés, l'objet utilisé comme verrou doit être soigneusement choisi.
- **Performance :** L'utilisation excessive de `synchronized` peut réduire la performance en limitant la concurrence.

### Tâches à réaliser

1. **Modification du code de l'exercice précédent :**
    - Revisitez le code de l'exercice précédent où plusieurs threads incrémentent une variable partagée.
2. **Implémenter la synchronisation :**
    - Utilisez `synchronized` pour synchroniser l'accès à la variable partagée dans la méthode d'incrément.
3. **Tester et observer :**
    - Exécutez le programme modifié plusieurs fois et vérifiez la valeur finale de la variable partagée.

Modifiez la méthode d'incrément comme suit :

https://github.com/CraftLR/workshop-multithreading-java/blob/e2ad580bfa98df991131801cc2604149a13934d7/src/main/java/dev/craftlr/exercice3/Main.java#L3-L31

### Questions de réflexion

- Comment le comportement du programme a-t-il changé après l'introduction de `synchronized` ?
- La valeur finale de `variablePartagee` est-elle maintenant conforme à vos attentes ? Pourquoi ?
- Modifier le code de l'exercice 2 et 3 pour mesurer l'impact de la synchronisation sur le temps de réponse du programme.

### Conclusion

Cet exercice illustre comment le verrouillage peut être utilisé avec le mot clé `synchronized`. La synchronisation permet d'éviter les conditions de concurrence en garantissant qu'un seul thread sera dans la section critique à la fois. Cette garantie ne se fait pas sans impact car elle va réduire drastiquement le niveau de parallélisme global du programme.

## Exercice 4 : Synchronisation avec `Object`

### Objectif

Cet exercice vise à explorer un mécanisme de synchronisation avancé en utilisant les méthodes synchronisées et les méthodes `wait()`, `notify()`, et `notifyAll()` héritées de la classe `Object`. Vous apprendrez à créer des conditions de synchronisation complexes pour contrôler l'accès aux ressources partagées de manière plus fine.

### Contexte

En Java, chaque objet peut servir de moniteur pour synchroniser l'accès aux sections critiques. Les méthodes `wait()`, `notify()`, et `notifyAll()` permettent de gérer l'attente et le réveil des threads en fonction de conditions spécifiques, offrant ainsi une gestion fine de la concurrence.

#### Fonctionnement des mécanismes de synchronisation

L'utilisation des méthodes `wait()`, `notify()`, et `notifyAll()` nécessite que le thread courant détienne le verrou de l'objet sur lequel ces méthodes sont appelées, généralement à l'intérieur d'un bloc `synchronized`.

#### Caractéristiques principales

1. **Exclusion mutuelle :**
    - Le bloc `synchronized` garantit qu'un seul thread à la fois peut accéder à la section critique.
2. **Attente et notification :**
    - `wait()` met le thread courant en attente jusqu'à ce qu'un autre thread appelle `notify()` ou `notifyAll()` sur le même objet.
    - `notify()` réveille un seul thread en attente sur cet objet.
    - `notifyAll()` réveille tous les threads en attente sur cet objet.

#### Utilisation

**Bloc synchronisé et attente :**

```java
synchronized (objet) {
    while (<condition n'est pas satisfaite>) {
        objet.wait();
    }
    // Section critique
}
```

**Notification :**

```java
synchronized (objet) {
    // Modifier la condition
    objet.notify(); // ou objet.notifyAll();
}
```

### Tâches à réaliser

1. **Créer un scénario de file d'attente de tâches :**
    - Implémentez une simulation de producteur-consommateur où un thread producteur crée des tâches et les ajoute à une file d'attente, et des threads consommateurs traitent ces tâches.
2. **Utiliser la synchronisation pour la file d'attente :**
    - Synchronisez l'accès à la file d'attente et utilisez `wait()` et `notify()` pour gérer les threads producteurs et consommateurs.
3. **Tester et observer le comportement :**
    - Assurez-vous que les consommateurs traitent les tâches lorsqu'elles sont disponibles et attendent autrement.

Voici un squelette de base pour votre programme :

https://github.com/CraftLR/workshop-multithreading-java/blob/e2ad580bfa98df991131801cc2604149a13934d7/src/main/java/dev/craftlr/exercice4/Main.java#L5-L72

### Questions de réflexion

- Comment l'utilisation de `synchronized`, `wait()`, et `notify()` aide-t-elle à coordonner l'accès à la file d'attente entre producteurs et consommateurs ?
- Quelle est la différence entre `notify()` et `notifyAll()` ? Dans quelles situations utiliseriez-vous l'un plutôt que l'autre ?
- Si vous augmentez le nombre de producteurs qu'observez-vous ?
- Si vous augmentez maintenant le nombre de consommateurs qu'observez-vous ?

### Conclusion

Cet exercice vous a introduit à la gestion avancée de la synchronisation, montrant comment utiliser `synchronized` avec `wait()` et `notify()` pour contrôler l'accès concurrent aux ressources partagées et coordonner les actions entre threads.

## Exercice 5 : Deadlocks et stratégies d'évitement

### Objectif

Cet exercice vise à comprendre ce qu'est un deadlock, comment il peut survenir dans un programme multithread, et à explorer des stratégies pour les détecter et les éviter.

### Contexte

Un deadlock en programmation multithread se produit lorsque deux threads ou plus se bloquent mutuellement, chacun attendant que l'autre libère une ressource. Cela peut arriver, par exemple, lorsque des threads verrouillent plusieurs ressources dans des ordres différents, créant ainsi un cercle d'attente impossible à briser.

#### Comment les deadlocks se produisent ?

Les deadlocks surviennent généralement dans les situations suivantes :

1. **Ressources exclusives :** Plusieurs threads tentent d'accéder simultanément à des ressources qui ne peuvent être utilisées que par un seul thread à la fois.
2. **Ordre de verrouillage incohérent :** Lorsque différents threads verrouillent des ressources dans des ordres différents, ils peuvent se retrouver dans une situation où chacun attend une ressource verrouillée par l'autre.

#### Stratégies pour détecter et prévenir les deadlocks

- **Ordre de verrouillage consistant :** Imposer un ordre global pour l'acquisition de verrous peut aider à éviter les deadlocks.
- **Timeouts :** Utiliser des timeouts avec `tryLock` dans `java.util.concurrent.locks.Lock` pour éviter d'attendre indéfiniment.
- **Outils de débogage :** Des outils comme les profilers Java ou les dump de threads peuvent aider à détecter les deadlocks.

### Tâches à réaliser

1. **Créer un scénario de deadlock :**
    - Écrivez un programme Java où deux threads essaient d'obtenir des verrous sur deux objets dans un ordre différent, menant à un deadlock.

2. **Modifier le programme pour éviter le deadlock :**
    - Révisez votre programme pour prévenir le deadlock, en assurant par exemple que les verrous soient toujours acquis dans le même ordre.

3. **Tester et observer :**
    - Examinez le comportement du programme avant et après vos modifications pour éviter le deadlock.

Voici le code initial pour créer un Deadlock :

https://github.com/CraftLR/workshop-multithreading-java/blob/e2ad580bfa98df991131801cc2604149a13934d7/src/main/java/dev/craftlr/exercice5/Main.java#L3-L39

### Questions de réflexion

- Comment le deadlock est-il survenu dans le programme initial ?
- Quelles stratégies avez-vous utilisées pour éviter le deadlock ?

### Conclusion

Cet exercice vous a sensibilisé aux problèmes de deadlocks en programmation multithread et vous a équipé de stratégies pour les détecter et les éviter. La compréhension des deadlocks et leur prévention sont essentielles pour développer des applications multithreads robustes et fiables.

## Exercice 6 : Le Dîner des philosophes

### Objectif

Appliquez vos connaissances sur les threads et la synchronisation pour résoudre le problème classique en informatique : le dîner des philosophes.

### Contexte

Le problème du dîner des philosophes illustre les défis de synchronisation dans un environnement multithread. Il implique plusieurs philosophes qui alternent entre manger et penser, nécessitant deux fourchettes pour manger, partagées avec leurs voisins, pouvant mener à des deadlocks et/ou à la famine.

### Tâches à réaliser

1. **Modéliser le scénario :**
    - Créez une classe `Philosophe` et une classe `Fourchette`.
    - Les philosophes doivent prendre les fourchettes à leur gauche et à leur droite pour manger.

2. **Implémenter la logique des philosophes :**
    - Implémentez la logique pour permettre aux philosophes de prendre des fourchettes, manger, puis les remettre et penser.

3. **Éviter les deadlocks et la famine :**
    - Assurez-vous de prévenir les deadlocks et la famine, par exemple, en adoptant une stratégie pour l'ordre de prise des fourchettes.

Voici le code de démarrage :

https://github.com/CraftLR/workshop-multithreading-java/blob/20de60f024883d234d4fa08c5ddfedebf58a99fd/src/main/java/dev/craftlr/exercice6/Philosophe.java#L5-L56

https://github.com/CraftLR/workshop-multithreading-java/blob/20de60f024883d234d4fa08c5ddfedebf58a99fd/src/main/java/dev/craftlr/exercice6/Fourchette.java#L3-L11

https://github.com/CraftLR/workshop-multithreading-java/blob/20de60f024883d234d4fa08c5ddfedebf58a99fd/src/main/java/dev/craftlr/exercice6/Philosophe.java#L5-L56

### Questions de réflexion

- Quelles stratégies avez-vous implémentées pour éviter les deadlocks et la famine ?

- Comment la gestion des ressources (fourchettes) influence-t-elle le comportement du système ?

### Conclusion

Ce classique problème de synchronisation vous aide à comprendre et à gérer les complexités des environnements multithreads. Les compétences acquises ici sont cruciales pour le développement d'applications parallèles fiables.

## Exercice 7 : Gestion d'un parking avec sémaphores

### Objectif

Utiliser un sémaphore pour gérer l'accès à un nombre limité de places de parking par des voitures (représentées par des threads). Le sémaphore limitera le nombre de voitures pouvant se garer simultanément.

### Contexte

Les sémaphores sont des mécanismes de synchronisation qui contrôlent l'accès à des ressources partagées par un nombre limité de threads. Les sémaphores sont représentés par la classe `java.util.concurrent.Semaphore`.

### Fonctionnement des sémaphores

Un sémaphore maintient un ensemble de permis (tickets) pour accéder à une ressource. Les threads demandent un permis pour accéder à la ressource et le rendent une fois leur tâche terminée.

### Tâches à réaliser

1. **Définir le nombre de places :**
    - Créez une variable pour représenter le nombre de places disponibles dans le parking.

2. **Créer le sémaphore :**
    - Utilisez la classe `Semaphore` pour créer un sémaphore qui gère l'accès au parking.

3. **Simuler les voitures :**
    - Chaque thread représente une voiture essayant de se garer.
    - Une voiture doit attendre si le parking est plein.

4. **Gérer l'entrée et la sortie :**
    - Utilisez le sémaphore pour assurer que le nombre de voitures dans le parking ne dépasse pas la capacité.
    - Après un certain temps, la voiture quitte le parking, libérant une place.

Voici le code de démarrage :


https://github.com/CraftLR/workshop-multithreading-java/blob/e2ad580bfa98df991131801cc2604149a13934d7/src/main/java/dev/craftlr/exercice7/Parking.java#L5-L36


### Questions de réflexion

- Comment le sémaphore facilite-t-il la gestion de l'accès concurrentiel au parking ?
- Quel impact aurait la modification du nombre de places de parking ou le nombre de voitures sur le comportement du programme ?

### Conclusion

Ce scénario illustre l'utilisation des sémaphores pour contrôler l'accès à des ressources limitées dans un environnement multithread, montrant comment gérer les ressources partagées pour éviter les surcharges et assurer une utilisation équitable.

## Exercice 8 : Synchronisation de deux threads par rendez-vous

### Objectif

Créer un scénario où deux threads doivent se synchroniser à un point de rendez-vous avant de continuer leur exécution, illustrant la coordination entre threads dans les opérations concurrentes.

### Contexte

Un rendez-vous est une situation où deux ou plus de threads attendent les uns les autres à un certain point avant de poursuivre leur exécution.

### Fonctionnement du rendez-vous

Java offre plusieurs mécanismes pour implémenter des points de rendez-vous entre threads, tels que l'utilisation d'objets `CountDownLatch`, `CyclicBarrier`, ou `Phaser`, chacun ayant ses propres particularités adaptées à différents cas d'usage.

### Tâches à réaliser

1. **Créer deux threads :**
    - Un thread pour "charger des données" et un autre pour "traiter des données".
2. **Point de rendez-vous :**
    - Utilisez un `CountDownLatch` pour synchroniser le thread de traitement afin qu'il attende que le thread de chargement ait terminé.
3. **Exécuter et observer :**
    - Lancez les threads et vérifiez que le traitement ne commence qu'après le chargement des données.

Voici le code de démarrage :

https://github.com/CraftLR/workshop-multithreading-java/blob/e2ad580bfa98df991131801cc2604149a13934d7/src/main/java/dev/craftlr/exercice8/Main.java#L5-L37

### Points clés

- **`CountDownLatch` :** Utilisé ici comme un moyen simple de synchroniser deux threads. Le latch est initialisé avec un compte de 1, signifiant qu'un seul événement (le chargement des données) doit se produire avant que le thread de traitement puisse poursuivre.
- **Chargement et Traitement :** Le thread de chargement simule un temps de chargement puis décrémente le latch, permettant au thread de traitement d'avancer.

### Questions de réflexion

- Quels sont les impacts de la synchronisation sur l'ordre d'exécution et l'utilisation des ressources ?
- Comment le comportement des threads change-t-il lorsqu'ils atteignent le point de rendez-vous ? Avez-vous observé des différences dans l'ordre d'exécution avant et après le rendez-vous ?
- Comment la synchronisation par rendez-vous affecte-t-elle l'utilisation des ressources partagées ? A-t-elle un impact sur la performance de l'application ?
- Pouvez-vous imaginer d'autres stratégies de synchronisation pour atteindre le même objectif que le rendez-vous ? Quels seraient leurs avantages et inconvénients par rapport à la méthode que vous avez utilisée ?
- Dans quelles situations un mauvais usage des mécanismes de rendez-vous pourrait-il conduire à un deadlock ? Comment pourriez-vous modifier votre code pour éviter ces deadlocks ?
- Comment géreriez-vous un scénario où plusieurs threads doivent se rencontrer à différents points de rendez-vous ? Quels défis cela pourrait-il présenter ?
- Pouvez-vous penser à des exemples concrets d'applications où les rendez-vous seraient essentiels ? Comment ces concepts s'appliquent-ils dans des scénarios réels ?

### Conclusion

Cet exercice montre comment synchroniser précisément des threads pour des opérations dépendantes, en utilisant `CountDownLatch` pour implémenter un point de rendez-vous. Cette technique est cruciale pour garantir la cohérence des données et l'ordre logique dans les applications multithreads.
