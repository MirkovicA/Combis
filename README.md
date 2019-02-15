# Combis
web aplikacija za natjecaj

Zadatak:

Potrebno je napraviti Java Web aplikaciju koja na sučelju ima proizvoljni header, footer i nekakav body u kojem će biti tablica, te buttoni učitaj i spremi podatke.

Button učitaj podatke mora učitati podatke iz datoteke „podaci.csv“ koja se nalazi u nekom folderu definiranom u config datoteci.

Prikazati podatke u tablici i jasno označiti ove koji imaju grešku s obzirom na kolonu poštanski broj.

Napraviti tablicu u bazi podataka(koristiti Postgresql ili sl.)  koja ima kolone Ime,Prezime,Poštanski br,Grad, Telefon.

Implementirati servisni sloj za snimanje podataka za gore kreiranu tablicu.

U bazu snimati samo retke koji nemaju grešku i nisu duplikati (jer tablica ne smije dozvoljavati duplikate). 

Onemogućiti snimanje duplikata, implementirati vraćanje greške iz procedure i logiranje u log file. 
