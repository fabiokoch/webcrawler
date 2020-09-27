### Web Crawler criado para site Submarino

# WEB CRAWLER
O Web Crawler irá buscar a cada 10 minutos na página do submarino, produtos Apple.
Caso encontre algum produto novo irá salvar em um banco de dados Postgres as informações encontradas.

#API's
A aplicação possui 3 API's:
GET /produtos onde retornará todos os produtos encontrados, GET /produts/price retornará os produtos ordenados pelo preço.