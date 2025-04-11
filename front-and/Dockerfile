FROM node:10 as build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build --prod

FROM httpd:2.4
COPY --from=build /app/dist/fronte-project /usr/local/apache2/htdocs
EXPOSE 80
