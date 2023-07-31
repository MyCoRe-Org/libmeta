# libmeta OAI Dublin Core library

Java APIs and models for OAI Dublin Core XML reading/creation.

* Homepage: <http://www.openarchives.org/OAI/openarchivesprotocol.html#dublincore>
* Specification (XSD): <http://www.openarchives.org/OAI/2.0/oai_dc.xsd>

## Usage

```
import org.mycore.libmeta.dcsimple.model.DCContributor;
import org.mycore.libmeta.dcsimple.model.DCTitle;
import org.mycore.libmeta.dcsimple.model.ElementType;
import jakarta.xml.bind.JAXBElement;

JAXBElement<ElementType> title =
  DCTitle.builder().value("Using Structural Metadata to Localize Experience of Digital Content").build();
JAXBElement<ElementType> contributor =
  DCContributor.builder().language("de").value("Max Meier").build();

OaiDc oaiDc = OaiDc.builder()
            .add(title)
            .add(contributor)
            .build();

String xml = OaiDcXMLProcessor.getInstance().marshalToString(oaiDc);            
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

Resulting OAI Dublin Core response XML of above code example:

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<oai_dc:dc xmlns:dc="http://purl.org/dc/elements/1.1/
           xmlns:oai_dc="http://www.openarchives.org/OAI/2.0/oai_dc/">
  <dc:title>Using Structural Metadata to Localize Experience of Digital Content</dc:title>
  <dc:contributor xml:lang="de">Max Meier</dc:contributor>
</oai_dc:dc>
```
