# code-with-quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Prerequisites

Before running this project, please ensure you have installed:

- **Java 17** or newer (required by Quarkus)
- **Maven 3.6+** (for building and running the Quarkus backend)
- **Node.js 18+ and npm** (for building and running the Angular frontend inside Quinoa)

## Running the the Backend REST API

To start the backend REST API with live reload enabled, open a terminal in the project root directory and run:

```shell script
./mvnw quarkus:dev
```

## Running the Angular Frontend (Quinoa)

To run the Angular frontend, open a new terminal and navigate to the frontend directory:

```shell script
cd src/main/webui
npm install
npm run start
```

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Quinoa ([guide](https://quarkiverse.github.io/quarkiverse-docs/quarkus-quinoa/dev/index.html)): Develop, build, and serve your npm-compatible web applications such as React, Angular, Vue, Lit, Svelte, Astro, SolidJS, and others alongside Quarkus.

## Provided Code

### Quinoa

Quinoa codestart added a tiny Vite app in src/main/webui. The page is configured to be visible on <a href="/quinoa">/quinoa</a>.

[Related guide section...](https://quarkiverse.github.io/quarkiverse-docs/quarkus-quinoa/dev/index.html)


### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
