# Airtel API based on criteria

Prerequisites to run
==========================
1. Java 8
2. MongoDB
3. IDE

Architecture
==========================

Spring boot microservice architecture is used to create API's. The json is parsed and stored into NoSQL MongoDB to
leverage the document based collections for scalability and faster output. This is done considering the file is static
so instead of parsing on each API invoking, I decided to parse during load time.
If the file is going to be generated every hour or streaming, spring batch can be used to poll on the folder to parse the data.

Documentation
==========================
`Swagger` is provided for the ease understanding the API which can be given to any novice user. The sample outputs are attached
in the sample output folder



