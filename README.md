# currencywatcher
# использовал Mysql, java.net пакет для отправки запроса к api CoinLore, @Scheduled - каждую минуту вывоз метода для обновления базы данных и проверки цен юзеров с текущими
пример вывода в консоль сообщених об изменений цены юзеров и актуальных(обновленных) цен
![image](https://github.com/DanikMotolyha/currencywatcher/assets/41682387/46e879cb-c728-4002-8824-aba17d7dfd04)
![image](https://github.com/DanikMotolyha/currencywatcher/assets/41682387/7618d946-3daf-489c-a504-fc34f0c3b0a2)

### Тех Задание :
<!DOCTYPE html>
<html>
<body class="stackedit">
  <div class="stackedit__html"><h1 id="cryptoсurrency-watcher"># CryptoСurrency watcher</h1>
<p>Написать простой REST-сервис просмотра котировок криптовалют</p>
<h2 id="функциональность">Функциональность</h2>
<ul>
<li>Просмотр списка доступных  криптовалют (REST-метод)</li>
<li>Просмотр актуальной цены для указаной криптовалюты  (REST-метод - код валюты передается пользователем)</li>
<li>Запасать в лог сообщение о изменении цены более чем на 1%. Для это пользователь регестрирует себя с помощью REST-метода notify и передает свое имя(username) и код криптовалюты(symbol). В момент регистрации cохраняяется текущаю цена указаной криптовалюты с привязкой к пользоватлю. Как только актуальная цена для указаной валюты поменялась более чем на 1%., в лог сервера выводится сообщение уровня WARN в котором указан: код валюты, имя пользователя и процент изменения цены с момента регистрации.</li>
</ul>
<h2 id="требования">Требования</h2>
<ul>
<li>Вы можете использовать  Java или Kotlin (любой версии)</li>
<li>Используте Spring или Spring Boot (можно использовать <a href="https://start.spring.io/">https://start.spring.io/</a>  для ускорения)</li>
<li>Актуальные цены храните в реляционной базе - можно использовать любую (H2, Mysql, Postgres,…)</li>
<li>Cписок доступных криптовалют предопределен и является частью конфигурации сервера<br>
Список валют:<br>
<code>[ {“id”:”90”,”symbol”:”BTC”}, {“id”:”80”,”symbol”:”ETH”}, {“id”:”48543”,”symbol”:”SOL”} ]</code></li>
</ul>
<ul>
<li>Раз в минуту актуальные цены для доступных криптовалют запрашиваются c внешнего источника CoinLore и сохраняются в базу данных.</li>
<li>Что бы получить актуальные цену по коду криптовалюты используйте open API <a href="https://www.coinlore.com/cryptocurrency-data-api#3">Crypto API | CoinLore</a><br>
Меthod <strong>Ticker (Specific Coin)</strong>:  <a href="https://api.coinlore.net/api/ticker/?id=90">https://api.coinlore.net/api/ticker/?id=90 (BTC)</a></li>
</ul>
<ul>
<li>Когда пользователь запрашивает актуальную цену для указаной криптовалюты - данные должны быть получены из базы данных</li>
<li>опубликуйте свою работу на github как публичный проект и скинте на ссылку по почте <a href="mailto:yana.kobzar@idfinance.com">mailto:yana.kobzar@idfinance.com</a>.</li>
</ul>
</div>
</body>

</html>


