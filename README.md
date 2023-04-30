# :fire: Afrominga :fire:

## :thought_balloon: What is it?

**Afrominga** is a web application that allows you to manage the information of the
**La Minga 8Afro-descendant Organization** on the general characterization of their community
in order to promote public policies that contribute to improving the quality of life.

## :checkered_flag: How to start?

- Install Java 17, go to [SDKMAN](https://sdkman.io/install) for install SDKMAN.

```shell
sdk install java x.y.z-open
```

- Set up JVM default

```shell
export JAVA_HOME='$HOME/.sdkman/candidates/java/current'
```

- Clone this repository

```shell
git clone https://github.com/sandersgutierrez/afrominga.git
```

- Run application

```shell
./gradlew :war
```