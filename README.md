<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE readme SYSTEM "readme.dtd">
<readme>
  <title>Java WebSocket Chat Client</title>
  
  <description>
    <paragraph>
      Dieses Projekt ist ein einfacher Java-WebSocket-Chat-Client. Der Client verbindet sich mit einem WebSocket-Server und ermöglicht es Benutzern, Nachrichten in Echtzeit zu senden und zu empfangen. Die empfangenen Nachrichten werden in einer grafischen Benutzeroberfläche (GUI) angezeigt.
    </paragraph>
  </description>
  
  <features>
    <list>
      <item>Verbindung zu einem WebSocket-Server herstellen</item>
      <item>Nachrichten in Echtzeit senden und empfangen</item>
      <item>GUI zur Anzeige der Nachrichten</item>
      <item>Unterstützung für mehrere Benutzer</item>
    </list>
  </features>
  
  <requirements>
    <list>
      <item>Java Development Kit (JDK) 8 oder höher</item>
      <item>IntelliJ IDEA oder eine andere Java-Entwicklungsumgebung</item>
      <item><code>java-websocket</code>-Bibliothek</item>
      <item><code>org.json</code>-Bibliothek</item>
    </list>
  </requirements>
  
  <installation>
    <steps>
      <step>Klone das Repository:</step>
      <step>Öffne das Projekt in deiner Entwicklungsumgebung.</step>
      <step>Füge die <code>java-websocket</code>- und <code>org.json</code>-Bibliothek zu deinem Projekt hinzu.</step>
    </steps>
  </installation>
  
  <usage>
    <steps>
      <step>Passe die <code>ServerConnection</code>-Klasse an, um die richtige WebSocket-Server-URL einzufügen.</step>
      <step>Führe die <code>JavaClientGUI</code>-Klasse aus, um die Anwendung zu starten.</step>
    </steps>
  </usage>
  
  <projectStructure>
    <list>
      <item><code>JavaClientGUI.java</code>: Erstellt die GUI und verwaltet Benutzerinteraktionen.</item>
      <item><code>ServerConnection.java</code>: Handhabt die WebSocket-Verbindung und das Senden von Nachrichten.</item>
      <item><code>MessageReceivedListener.java</code>: Interface für den Empfang von Nachrichten.</item>
      <item><code>MessageProcessor.java</code>: Verarbeitet empfangene Nachrichten und formatiert sie für die Anzeige in der GUI.</item>
    </list>
  </projectStructure>
  
  <contribution>
    <paragraph>Beiträge sind willkommen! Bitte erstelle einen Fork des Projekts und öffne eine Pull-Request mit deinen Änderungen.</paragraph>
  </contribution>
  
  <license>
    <paragraph>Dieses Projekt ist privat.</paragraph>
  </license>
</readme>
