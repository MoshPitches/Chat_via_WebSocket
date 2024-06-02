# Java WebSocket Chat Client

## Beschreibung
Dieses Projekt ist ein einfacher Java-WebSocket-Chat-Client. Der Client verbindet sich mit einem WebSocket-Server und ermöglicht es Benutzern, Nachrichten in Echtzeit zu senden und zu empfangen. Die empfangenen Nachrichten werden in einer grafischen Benutzeroberfläche (GUI) angezeigt.

## Funktionen
- Verbindung zu einem WebSocket-Server herstellen
- Nachrichten in Echtzeit senden und empfangen
- GUI zur Anzeige der Nachrichten
- Unterstützung für mehrere Benutzer

## Anforderungen
- Java Development Kit (JDK) 8 oder höher
- IntelliJ IDEA oder eine andere Java-Entwicklungsumgebung
- `java-websocket`-Bibliothek
- `org.json`-Bibliothek

## Installation
1. Klone das Repository.
2. Öffne das Projekt in deiner Entwicklungsumgebung.
3. Füge die `java-websocket`- und `org.json`-Bibliothek zu deinem Projekt hinzu.

## Verwendung
1. Passe die `ServerConnection`-Klasse an, um die richtige WebSocket-Server-URL einzufügen.
2. Führe die `JavaClientGUI`-Klasse aus, um die Anwendung zu starten.

## Projektstruktur
- `JavaClientGUI.java`: Erstellt die GUI und verwaltet Benutzerinteraktionen.
- `ServerConnection.java`: Handhabt die WebSocket-Verbindung und das Senden von Nachrichten.
- `MessageReceivedListener.java`: Interface für den Empfang von Nachrichten.
- `MessageProcessor.java`: Verarbeitet empfangene Nachrichten und formatiert sie für die Anzeige in der GUI.

## Beitrag
Beiträge sind willkommen! Bitte erstelle einen Fork des Projekts und öffne eine Pull-Request mit deinen Änderungen.

## Lizenz
Dieses Projekt ist privat.
