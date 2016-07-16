# clinic
Progetto: ClinicaACME

Tecnologie usate: HTML, CSS, Bootstrap, JPA, OpenJpa, Java, Spring, SpringMVC, Maven.

Descrizione testuale per i casi d'uso di:

Caso d'uso UC1: consulta offerta
Attore primario: utente non registrato
  Scenario principale di successo: 
  - L'utente consulta l'elenco delle tipologie di esame
  - L'utente sceglie una tipologia di esame e ne richiede i dettagli 
  - Il sistema mostra i dettagli della tipologia di esame scelta dall'utente
    (nome, descrizione, costo e prerequisiti)
  - L'utente ripete i passi precedenti un numero indefinito di volte

Caso d'uso UC2: crea esame (prenotazione)
Attore primario: amministrazione
  Scenario principale di successo: 
  - L'amministrazione crea un esame
  - L'amministrazione imposta una tipologia di esame all'esame creato
  - L'amministrazione associa un paziente all'esame creato
  - L'amministrazione associa un medico all'esame creato
  - Il sistema registra l'esame (impostando automaticamente la data di prenotazione)
  Precondizioni: l'amministratore è identificato e autenticato

Caso d'uso UC3: consulta risultati proprio esame
Attore primario: paziente
  Scenario principale:
  - Il paziente consulta l'elenco dei propri esami
  - Il sistema mostra al paziente l'elenco dei suoi esami
  - Il paziente chiede il dettaglio di un esame
  - Il sistema mostra il dettaglio dell'esame
  - Il paziente ripete i passi precedenti finché necessario
  Precondizioni: il paziente è identificato e autenticato

Caso d'uso UC4: inserimento tipologia di esame
Attore primario: amministrazione
  Scenario principale:
  - L'amministrazione inserisce una nuova tipologia di esame
    specificando nome, costo e descrizione
  - Il sistema registra la tipologia di esame
  - L'amministrazione può aggiungere un prerequisitio o un indicatore
    alla tipologia scelta.
  I punti precedenti vengono ripetuti fino a che necessario
  Precondizioni: l'amministratore è identificato e autenticato

Caso d'uso UC5: esami effettuati da un medico
Attore primario: amministrazione
  Scenario principale:
  - L’amministrazione fornisce nome e cognome di un medico
  - Il sistema mostra all’amministrazione tutti gli esami effettuati dal medico
  Precondizioni: l’amministratore è identificato e autenticato

Caso d'uso UC6: inserimento risultati esame
Attore primario: amministrazione
  Scenario principale:
  - L'amministrazione visualizza l'elenco di tutti gli esami
  - L'amministrazione sceglie un esame per il quale inserire i risultati
  - Il sistema presenta all'amministratore l'esame corrispondente con lista indicatori-valori(vuoto)
  - L'amministratore inserisce tutti i valori dei risultati dell'esame
  Precondizioni: l'amministratore è identificato e autenticato

Caso d'uso UC7: Inserimento medico
Attore primario: amministrazione
  Scenario principale:
  - L'amministrazione crea un nuovo medico specificando
    nome, cognome e specializzazione
  - L'amministrazione visualizza la lista dei medici inseriti
  Precondizioni: l’amministratore è identificato e autenticato

Caso d'uso UC8: Inserimento paziente
Attore primario: amministrazione
  Scenario principale:
  - L'amministrazione crea un nuovo paziente specificando
    nome, cognome, username e password (utili per futuro accesso del paziente)
  - L'amministrazione visualizza la lista dei pazienti inseriti
  Precondizioni: l’amministratore è identificato e autenticato
