## Project 2

- Using [`Java and JDK 11.`](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [Description](./DESCRIPTION.md)
- [References](./REFERENCES.md)
- [Diagrams](./DIAGRAMS.md)

### Contributors / Students

- Mert Dede
    - GitHub: [`Anaxilaus`](https://github.com/Anaxilaus)
    - No: `2016280010`

- Uluğbey Alp
    - GitHub: [`UlugbeyAlp`](https://github.com/UlugbeyAlp)
    - No: `2016280002`
    
Team name: `MU.` Stands for `M`ert and  `U`luğbey.


## Project Structure

```
│   ├── src
│   │   ├── main
│   │   │   ├── java.mu.Project
│   │   │   │   ├── Main [Manifest class]
│   │   │   │   ├── Models
│   │   │   │   ├── Controllers
│   │   │   │   ├── Views
│   │   │   │   ├── Logger
│   │   │   │   ├── Connector
│   │   │   ├── resources [SQL scripts]
│   │   │   │   ├── schema.sql
│   │   │   │   ├── prototype.sql
│   ├── bin
│   │   ├── Project-1.1.jar [Executable fat jar]
│   │   │   ├── mu.Project [version 1.1]
│   │   │   ├── resources
│   │   │   ├── sqlite-jdbc [version 3.27.2.1]
├── *.md
│   ├── resources [for MarkDown files]
├── pom.xml [Project Object Model]
├── .gitignore
```

## Launching

#### Click to install without cloning: [bin/Project-1.1.jar](./bin/Project-1.1.jar?raw=yes)

This jar file is executable and contains dependencies and resources too, thus portable.


You can take a look at what's inside by following command:

```
$ jar tf Project-1.1.jar
```

Launch portable jar on command line as below to run the program:

```
$ java -jar Project-1.1.jar
```

**Note:** Java 11 or higher.

## Usage
Testing accounts with default password, `"password"`

- Customer account: `customer@tester.com`
- Admin account: `admin@tester.com`
	
**Note:** Trying to log in with a new email address and password will result on a new *customer* account.

