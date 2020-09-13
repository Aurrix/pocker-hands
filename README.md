# pocker-hands
Project euler problem 58

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
an 
### Prerequisites

Java SE JDK 1.11,

GRADLE 6.5

### Installing (Windows)

1. Download and extract repository

2. Open command line at extracted directory

3. Type:
```
gradle build
```
4. Gradle will generate jar at ../product-adviser/build/libs/

### Lombok Annotaion Processing

This project uses Lombok. Majority of getters, setters and constructors being created during runtime. In order for IDE to do not show errors during compile time, you would need to enable Annotaion processing. To enable annotation processing in Intellij go to: "Settings > Build > Compiler > Annotation Processors".

### Passing file

Application accepts as first command line argument an absolute path to a TXT file which contains hands per line: 10 consecutive cards (5 per player) formatted in following manner:

VS (where V is card value and S is a suit), e.g. 4D 6S 9H QH QC 4D 6S 9H QH QC

If no files passed application will access default example.txt file.

### Testing

To run test cases repeat steps 1,2 then type:
```
gradle test
```
## License

This project is licensed under the [Apache License 2](https://www.apache.org/licenses/LICENSE-2.0)
