FROM node:lts-alpine
WORKDIR /usr/src/app
# Définition de la variable d'environnement NODE_OPTIONS pour augmenter la mémoire allouée à Node.js
ENV NODE_OPTIONS="--max-old-space-size=4096"
COPY ./front/package.json .
RUN npm install

RUN mkdir node_modules/.cache && chmod -R 777 node_modules/.cache

COPY . .
COPY ./front/ /app

# Modification de cette ligne pour exécuter l'application en mode "live reload" en dev
# et pour la route vers le dossier "public/index.html" sans utiliser "nodemon"
CMD [ "npm", "run", "start" ]

