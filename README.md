# AlgorithmComparator
Olio-ohjelmoinnin harjoitustyö 2021

## Sisällys
### 1 Tehtävän kuvaus ja analysointi
### 2 Ratkaisuperiaate
### 2.1 Käyttöliittymä
### 2.2 Metodeista ja luokista
### 2.3 Mittaus
### 2.4 Testaus
### 3 Muuta
### 3.1 Ohje ohjelman ajoon
### 3.2 Käyttöohje
### 3.3 Tekijät

### 1. Tehtävän kuvaus ja analysointi
Tehtävänä oli luoda Java ohjelma olio-ohjelmoinnin perusteet -kurssin harjoitustyönä avoimen
yliopiston kurssilla 2021. Tarkoituksena on soveltaa kurssilla opetettuja asioita käytännössä ja työ
on tavallaan osaamisnäyte opitusta. Mahdollisuutena oli valita työn aihe listasta tai kehitellä oma
idea ohjelmalle. Muutamiin hakualgoritmeihin aikaisemmin hieman tutustuneena kiinnosti ajatus
ohjelmasta, joka havainnollistaisi eri algoritmien hyötyjä tai eroja toisiinsa nähden. Havainnoinnin
painopiste harjoitustyössä on keskittynyt algoritmeilla tehtävän haun nopeuteen. Ideana on myös
toteuttaa ohjelmaan yksinkertainen käyttöliittymä, jonka kautta käyttäjä voi testata algoritmeja
haluamillaan parametreilla. Perimmäisenä ajatuksena työssä on alusta asti ollut myös sellaisen
toimivan pohjan luominen, jota voi laajentaa ja parannella jatkossa opituilla asioilla.

### 2. Ratkaisuperiaate
Java-ohjelma AlgorithmComparator ajetaan luokan Main avulla, joka kutsuu metodia test. Metodi
vastaa Javan luokan Scanner lukijan avulla käyttäjäsyötteestä ja komentoriville toteutetusta
käyttöliittymästä. Testausmetodi myös kutsuu ohjelman muiden luokkien metodeja välittäen niille
käyttäjältä saatua syötettä, sekä tuoden ohjelman tulostetta käyttäjälle. Ohjelmassa on omat luokat
algoritmeille, jotka toteuttavat tavoillaan abstraktin luokan PatternSearch.

### 2.1 Käyttöliittymä
Käyttöliittymä on melko yksinkertainen komentorivillä toimiva toteutus, joka pyritään toteuttamaan
mahdollisimman käyttäjäystävälliseksi ja selkeäksi. Se vastaa ohjelman näkyvästä osasta, sekä
syötteen ja tulosteen siirtelystä ohjelman muihin osiin.

### 2.2 Metodeista ja luokista
Keskeisinä ratkaisuina voidaan ajatella edellä mainittujen lisäksi abstraktia luokkaa PatternSearch,
joka sisältää rakennusohjeita hakualgoritmi luokkia varten. Ohjelman luokat BruteSearch ja
KMPSearch toteuttavat kyseisen abstraktin luokan tavoillaan. Kyseisten luokkien getHits -metodin
käytännön luokkakohtainen toteutus on keskeisin, sillä se sisältää varsinaisen haun suorittavan
algoritmin Java-ohjelmointikielisen toteutuksen.

### 2.3 Mittaus
Haun suoritusaikaa mittaava metodi getTime hyödyntää Javan järjestelmän nanoTime menetelmää
mahdollisimman tarkan tuloksen tuottamiseksi. Varsinainen algoritminen haku tehdään kutsumalla
metodia getHits, jota getTime kellottaa.

### 2.4 Testaus
Ohjelman testausta on toteutettu useilla erilaisilla merkkijonosyötteillä ja tekemällä tahallisia
käyttövirheitä. Näihin kuului esimerkiksi 'väärien' valintojen tekemistä komentorivin
käyttöliittymässä pyrkimyksenä tahallisesti kaatamaan ohjelman suoritus. Ohjelma toimi testeissä
kaatumatta ja halutulla tavalla lähes poikkeuksetta. Testaus kuitenkin paljasti joitain ongelmia
suorittaessa hakuja metodeilla ilman käyttäjän syöttämiä parametreja. Tästä syystä ohjelmaa
muutettiin siltä osin siten, että pyritään varmistumaan parametrien asettamisesta. Lisäksi
testauksen avulla on pyritty varmistumaan, että ohjelman käyttäminen olisi käyttäjälle
mahdollisimman helppoa, selkeää ja hyvin opastettua.

### 3. Muuta
Ohjelmakoodissa luokilla on joitain toteutuksia tai muuttujia, joita ohjelman nykyinen palautettava
versio ei vielä hyödynnä tavalla, mitä varten ne on sisällytetty.

### 3.1 Ohje ohjelman ajoon
Suorita Java-ohjelma luokasta Main.

### 3.2 Käyttöohje
Ohjelmasta löytyy ajonaikainen ohjeistus ja informointi käyttäjää varten. Ajettaessa ohjelma
tulostaa ohjeet, sekä käyttäjälle tarjolla olevat vaihtoehdot komentoriville. Valintojen tekeminen
tapahtuu syöttämällä komentoriville valintaa vastaava numero ja painamalla Enter.
1. Valinnan kautta käyttäjä pääsee asettamaan merkkijonojen parametrit, joilla algoritmien ajo
tehdään. Ohjelmalle annetaan syötteenä haluttu merkkijono komentoriville syöttäen ja painamalla
Enter. Kysely järjestys on hahmo-aineisto.
2. Valinnan kautta ohjelma suorittaa haut annetuilla parametreillä ohjelman käytössä olevia
algoritmeja hyödyntäen. Palauttaa käyttäjälle osumien määrän, sijainnit tai vaihtoehtoisesti niiden
puutteen. Ohjelma palauttaa edellä mainitun metodikohtaisesti ja lisäksi kertoo käyttäjälle hakuun
kuluneen ajan nanosekunneissa.
9. Valinnan kautta käyttäjä voi lopettaa ohjelman käytön, Scanner lukija suljetaan ja suoritus
päättyy.
Huom. Ohjelmaa oletetaan käytettävän syöttämällä ensin parametrit 1. valinnassa, mutta mikäli
näin ei tehdä, tulisi käyttäjälle tulla ilmoitus, joka opastaa ohjelman käytössä mahdollisen
käyttövirheen sattuessa.

### 3.3 Tekijät
Työn toteutuksesta kaikilta osin vastasi Toni.
