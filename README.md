Progetto Catalogo Bibliografico e Gestione Prestiti
Analisi e Scelte Progettuali (ERD)
Ereditarietà (JOINED Table): Ho utilizzato la strategia InheritanceType.JOINED per la classe ElementoCatalogo che permette di avere tabelle separate per Libro e Rivista, garantendo una migliore normalizzazione del database ed evitando colonne con valori nulli per i dati specifici.

Identificazione Univoca (ISBN): l'ho scelto come chiave primaria (String) per gli elementi del catalogo in modo da garantire l'univocità senza ricorrere a ID numerici autogenerati.

Gestione Relazioni: la tabella Prestito collega Utenti e Catalogo tramite relazioni MTO. La data di restituzione prevista viene calcolata automaticamente a 30 giorni dalla data di inizio prestito nel costruttore della classe.