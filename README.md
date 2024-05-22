# LibMeta - Java Object Models and APIs for Common Library Metadata Standards
**These Java libraries provide a set of Java models and APIs,
which provide a unified approach to the creation and processing of library metadata objects.**

- A corresponding Java object model was derived for each standard.
- JAXB annotations (Java API for XML-Binding) are used with XML-based standards to specify
  the mapping between the Java object model and it‘s XML representation.
- The JSON Binding API is used for the serialization and deserialization of metadata objects
  in JSON-based standards.
- Validator classes are used to check XML data against the corresponding XML Schemas.

### Covered Standards
- Dublin Core (https://www.dublincore.org)
- MARC (https://www.loc.gov/marc/bibliographic)
- MODS (https://www.loc.gov/standards/mods)
- METS (https://www.loc.gov/standards/mets)
- ALTO (https://www.loc.gov/standards/alto)
- PICA (https://format.gbv.de/pica)

### Deployed to Maven
The compiled libraries are deployed to the Maven Central Repository:  
https://repo1.maven.org/maven2/org/mycore/libmeta/


