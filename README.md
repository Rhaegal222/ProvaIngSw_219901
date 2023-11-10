Scrivere all'interno di una classe con nome "MyListUtil" una funzione "sort" che, data una lista di numeri interi, organizzi gli elementi sia in ordine crescente che in ordine decrescente, a seconda della scelta dell'utente.
``` java
public List<integer> sort(List <integer> list, int order){}
```
``` java
order = 0 //ascendente
order = 1 //decrescente
```

Nota: si consiglia di scrivere il proprio algoritmo per ordinare i numeri

A tal fine:
1. Creare un progetto Maven. (Potete usare l'archetype: maven-archetype-quickstart)
2. Tracciare le modifiche usando Git. Si deve creare una branca con nome "dev" per scrivere il codice, e in fine dare merge con la branca principale
3. Testare la funzione scritta usando Junit e scrivere almeno due casi di prove, nel caso in cui sia stata scritta piu' di una funzione è comunque necessario riportare le prove delle stesse. È richiesto l'uso di @Before o @BeforeClass a seconda dei casi
4. Installare la libreria Joda-Time e stampare la data e l'ora dell'inizio e della fine di tutti i tests. Il formato di stampa è a scelta personale.
5. Caricare il codice sorgente su un repository GitHub evitando di caricare quei files che riguardano l'impostazione dell'IDE e infine la cartella "target" creata da Maven. il nome del progetto su GitHub deve essere nel formato: ProvaIngSw_{matricola}

<ul></ul>

1. Creare un progetto Maven
    1. IntelliJ -> New Project -> Maven Archetype
    2. Compilazione dei campi
        - Nome: ProvaIngSw_{matricola}
        - Location: Percorso locale del progetto
        - Create Git repository: ON
        - JDK: 17
        - Catalog: Maven Central
        - Archetype: org.apache.maven.archetypes:maven-archetype-quickstart
        - Version: 1.4
    3. Aggiunta delle dependencies
        1. Aprire il file pom.xml
        2. Aggiungere sotto `</properties>`
        ``` java
            <dependencies>
                <dependency>
                    <groupId>org.junit.jupiter</groupId>
                    <artifactId>junit-jupiter-api</artifactId>
                    <version>5.8.0</version>
                    <scope>test</scope>
                </dependency>
                <dependency>
                    <groupId>org.junit.jupiter</groupId>
                    <artifactId>junit-jupiter-engine</artifactId>
                    <version>5.8.0</version>
                    <scope>test</scope>
                </dependency>
                <dependency>
                    <groupId>org.mockito</groupId>
                    <artifactId>mockito-core</artifactId>
                    <version>3.12.4</version>
                    <scope>test</scope>
                </dependency>
                <dependency>
                    <groupId>joda-time</groupId>
                    <artifactId>joda-time</artifactId>
                    <version>2.10.13</version>
                </dependency>
                <dependency>
                    <groupId>junit</groupId>
                    <artifactId>junit</artifactId>
                    <version>4.13.1</version>
                    <scope>test</scope>
                </dependency>
            </dependencies>
        ```
2. Tracciare le modifiche usando Git
    1. Aprire il terminale di IntelliJ
    2. Digitare
        -  Per cambiare il nome del branch locale da master a main 
        ``` 
        git branch -m main
        ```
        - Per aggiungere al branch main i file del progetto
        ``` 
        git add .
        git commit -m "Init"
        ```
        - Per creare il branch dev
        ``` 
        git branch dev
        ```
        - Per passare dal branch main al branch dev
        ``` 
        git checkout dev
        ```
3. Creare la classe MyListUtil
    ``` java
    package it.unical.ingsw;

    import java.util.Collections;
    import java.util.List;

    public class MyListUtil {
        public static List<Integer> sort(List<Integer> list, int order) {
            if (order == 0) {
                Collections.sort(list);
            } else if (order == 1) {
                Collections.sort(list, Collections.reverseOrder());
            }
            return list;
        }
    }
    ```
4. Creare la classe per i test
    ``` java
    package it.unical.ingsw;

    import org.joda.time.DateTime;
    import org.junit.After;
    import org.junit.Before;
    import org.junit.Test;
    import static org.junit.Assert.assertEquals;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    
    public class MyListUtilTest {
    private List<Integer> list;
    
        @Before
        public void setUp() {
            list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5));
        }
    
        @Test
        public void testSortAscending() {
            List<Integer> sortedList = MyListUtil.sort(list, 1);
            assertEquals(Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9), sortedList);
        }
    
        @Test
        public void testSortDescending() {
            List<Integer> sortedList = MyListUtil.sort(list, -1);
            assertEquals(Arrays.asList(9, 6, 5, 5, 5, 4, 3, 3, 2, 1, 1), sortedList);
        }
    
        @Before
        public void printStart() {
            DateTime start = new DateTime();
            System.out.println("Start time: " + start.toString("yyyy-MM-dd HH:mm:ss.SSS"));
        }
    
        @After
        public void printEnd() {
            DateTime end = new DateTime();
            System.out.println("End time: " + end.toString("yyyy-MM-dd HH:mm:ss.SSS"));
        }
    }
    ```
5. Caricare il codice sorgente su GitHub
    1. Aggiungere le modifiche al branch dev
        ```
        git commit -a -m "Sviluppo terminato"
        ```
    2. Spostarsi nel branch main
        ```
        git checkout main
        ```
    3.  Esegui il comando seguente per unire il branch dev nel branch corrente
        ```
        git merge dev
        ```
    4. Condividere il branch su GitHub
        > Git -> GitHub -> Share Project On GitHub
        > Cliccare su Share
