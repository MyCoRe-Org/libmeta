# libmeta Dublin Core Simple library

Java APIs and models for Dublin Core Simple metadata XML reading/creation.

* Homepage: <https://www.dublincore.org/>
* Specification (XSD): <https://www.dublincore.org/schemas/xmls/simpledc20021212.xsd>

## Usage

```
import org.mycore.libmeta.dcsimple.model.ElementType;
import jakarta.xml.bind.JAXBElement;

JAXBElement<ElementType> contributor = DCContributor.builder().language("de").value("Max Meier").build();

String xml = DCSimpleXMLProcessor.getInstance().marshalToString(contributor);
```
All 15 Dublin Core Simple elements have it's own builder:

* `<dc:contributor>`: DCContributor
* `<dc:coverage>`: DCCoverage
* `<dc:creator>`: DCCreator
* `<dc:date>`: DCDate
* `<dc:description>`: DCDescription
* `<dc:format>`: DCFormat
* `<dc:identifier>`: DCIdentifier
* `<dc:language>`: DCLanguage
* `<dc:publisher>`: DCPublisher
* `<dc:relation>`: DCRelation
* `<dc:rights>`: DCRights
* `<dc:source>`: DCSource
* `<dc:subject>`: DCSubject
* `<dc:title>`: DCTitle
* `<dc:type>`: DCType

## Examples

Dublin Core Simple element as XML:

```
<dc:contributor xmlns:dc="http://purl.org/dc/elements/1.1/" xml:lang="de">Max Meier</dc:contributor>
```
