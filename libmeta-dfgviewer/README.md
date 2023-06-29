# libmeta DFG-Viewer library

Java APIs and models for DFG-Viewer metadata XML reading/creation.

Special XML-Elements for providing metadata for the DFG-Viewer.

Specified in "METS Anwendungsprofil für digitalisierte Medien 2.3.1" (<https://dfg-viewer.de/fileadmin/groups/dfgviewer/METS-Anwendungsprofil_2.3.1.pdf>).

Two top level elements are available:

* "Rights" - for providing legal metadata
* "Links" - for providing links to further metadata or related resources

Examples:

```
<dv:rights>
  <dv:owner>SLUB Dresden</dv:owner>
  <dv:ownerLogo>http://digital.slub-dresden.de/logo.gif</dv:ownerLogo>
  <dv:ownerSiteURL>http://digital.slub-dresden.de/</dv:ownerSiteURL>
  <dv:ownerContact>mailto:sebastian.meyer@slub-dresden.de</dv:ownerContact>
  <dv:license>cc-by</dv:license>
</dv:rights>

<dv:links>
  <dv:reference linktext="OPAC">http://slub-dresden.de/FOZK.pl?PPN=356448053</dv:reference>
  <dv:reference linktext="WorldCat">http://worldcat.org/search?356448053</dv:reference>
  <dv:presentation>http://slub-dresden.de/356448053</dv:presentation>
  <dv:sru>http://digital.slub-dresden.de/sru/356448053</dv:sru>
  <dv:iiif>http://digital.slub-dresden.de/iiif/356448053.xml</dv:iiif>
</dv:links>
```