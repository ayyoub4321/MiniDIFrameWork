# MiniDIFramework

## Auteurs

- **Nom :** Ayyoub  
- **Prénom :** Ait mansour 
- **Filière :**SDIA
- **TP :** TP1


## 📌 1. Introduction

Ce projet illustre la création d’un **conteneur IoC** simple (à la manière de Spring) capable de :

- Scanner les classes annotées avec `@Component`
- Injecter les dépendances via `@Inject`
- Charger des définitions de beans depuis un fichier `beans.xml`
- Gérer l’injection par **constructeur**, **setter** ou **attribut**

---

## 🧱 2. Structure du Projet
MiniDIFramework/
├── pom.xml
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── org/example/
│ │ │ ├── annotations/
│ │ │ │ ├── Component.java
│ │ │ │ └── Inject.java
│ │ │ ├── core/
│ │ │ │ └── AnnotationContext.java
│ │ │ ├── model/
│ │ │ │ └── Task.java
│ │ │ ├── repository/
│ │ │ │ └── TaskRepository.java
│ │ │ ├── service/
│ │ │ │ └── TaskService.java
│ │ │ └── xml/
│ │ │ ├── AppMain.java
│ │ │ └── AppMainXML.java
│ │ └── resources/
│ │ └── beans.xml
└── target/

---

## ⚙️ 3. Fonctionnalités principales

- Injection de dépendances par :
  - **Champ** avec `@Inject`
  - **XML** (`beans.xml`)
- Marquage des classes gérées avec `@Component`
- Gestion centralisée des dépendances via `AnnotationContext`

---

## 📂 4. Description des modules

### ✅ `annotations`

- `@Component` : Indique qu’une classe est un composant à gérer.
- `@Inject` : Marque un champ pour y injecter une dépendance.

### ⚙️ `core`

- `AnnotationContext` : Conteneur principal. Scanne les annotations, instancie les composants, et applique les injections nécessaires.

### 📦 `model`

- Contient la classe `Task` qui représente un objet métier.

### 📂 `repository`

- `TaskRepository` : Accès aux données pour les tâches.

### 🧠 `service`

- `TaskService` : Logique métier associée aux tâches. Reçoit les dépendances automatiquement injectées.

### 🚀 `xml`

- `AppMain` : Lanceur utilisant l’approche annotation.
- `AppMainXML` : Lanceur utilisant la configuration XML.

---

## 🛠️ 5. Fichier `beans.xml`

Le fichier `beans.xml` est utilisé pour déclarer manuellement les beans à instancier et injecter.

```xml
<beans>
  <bean id="taskRepository" class="org.example.repository.TaskRepository"/>
  <bean id="taskService" class="org.example.service.TaskService">
    <property name="repository" ref="taskRepository"/>
  </bean>
</beans>



