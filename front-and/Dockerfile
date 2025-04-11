# Usa a imagem Node oficial para construir e servir a aplicação
FROM node:12 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /frontend

# Copia o package.json e o package-lock.json (se existir)
COPY package*.json ./

# Instala as dependências do projeto
RUN npm install

# Copia o restante dos arquivos da aplicação
COPY . .

# Compila a aplicação Angular para produção
RUN npm run build --prod

# Usa uma imagem do Nginx para servir os arquivos estáticos Angular
FROM nginx:alpine

# Copia os arquivos compilados do build anterior para o diretório padrão do Nginx
COPY --from=build /frontend/dist /usr/share/nginx/html

# Exposição da porta padrão do Nginx
EXPOSE 80

# Comando padrão para iniciar o Nginx
CMD ["nginx", "-g", "daemon off;"]
