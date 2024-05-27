package org.mycore.libmeta.alto.junit5.model;

import org.junit.Assert;
import org.junit.Test;
import org.mycore.libmeta.alto__4.Alto4XMLProcessor;
import org.mycore.libmeta.alto__4.model.Alto;
import org.mycore.libmeta.alto__4.model.description.Description;
import org.mycore.libmeta.alto__4.model.description.FileIdentifier;
import org.mycore.libmeta.alto__4.model.description.FileName;
import org.mycore.libmeta.alto__4.model.description.MeasurementUnit;
import org.mycore.libmeta.alto__4.model.description.Processing;
import org.mycore.libmeta.alto__4.model.description.ProcessingSoftware;
import org.mycore.libmeta.alto__4.model.description.SourceImageInformation;
import org.mycore.libmeta.alto__4.model.layout.Layout;
import org.mycore.libmeta.alto__4.model.layout.Page;
import org.mycore.libmeta.alto__4.model.layout.PageSpace;
import org.mycore.libmeta.alto__4.model.layout.Points;
import org.mycore.libmeta.alto__4.model.layout.Shape;
import org.mycore.libmeta.alto__4.model.layout.block.ComposedBlock;
import org.mycore.libmeta.alto__4.model.layout.block.TextBlock;
import org.mycore.libmeta.alto__4.model.layout.block.TextLine;
import org.mycore.libmeta.alto__4.model.layout.block.textline.HYP;
import org.mycore.libmeta.alto__4.model.layout.block.textline.SP;
import org.mycore.libmeta.alto__4.model.layout.block.textline.TextlineString;
import org.mycore.libmeta.alto__4.model.layout.shape.Polygon;

public class AltoTest {

    @Test
    public void test1() {
        try {
            String s
                = """
                    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                    <alto xmlns="http://www.loc.gov/standards/alto/ns-v4#" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.loc.gov/standards/alto/ns-v4# https://www.loc.gov/standards/alto/v4/alto.xsd">
                      <Description>
                        <MeasurementUnit>pixel</MeasurementUnit>
                        <sourceImageInformation>
                          <fileName>https://doro.uni-rostock.de/api/iiif/image/v2/demel%252Fk0002%252Fphys_0177/full/full/0/default.jpg</fileName>
                          <fileIdentifier>http://purl.uni-rostock.de/demel/k0002/phys_0177</fileIdentifier>
                        </sourceImageInformation>
                        <Processing ID="IdOcr">
                          <processingDateTime>2024-04-27T17:44:12.116+02:00</processingDateTime>
                          <processingStepSettings>textRecognitionModelId:473|lineDetectionModelId:pylaia</processingStepSettings>
                          <processingSoftware>
                            <softwareCreator>READ COOP</softwareCreator>
                            <softwareName>Transkribus Processing API</softwareName>
                            <softwareVersion>1.2.0</softwareVersion>
                            <applicationDescription>metagrapho API: https://transkribus.eu/processing/v1/openapi.json</applicationDescription>
                          </processingSoftware>
                        </Processing>
                      </Description>
                      <Layout>
                        <Page HEIGHT="1416" ID="Page1" PHYSICAL_IMG_NR="1" WIDTH="1787">
                          <TopMargin HEIGHT="0" HPOS="0" VPOS="0" WIDTH="1787"/>
                          <LeftMargin HEIGHT="1416" HPOS="0" VPOS="0" WIDTH="0"/>
                          <RightMargin HEIGHT="1416" HPOS="1787" VPOS="0" WIDTH="0"/>
                          <BottomMargin HEIGHT="0" HPOS="0" VPOS="1416" WIDTH="1787"/>
                          <PrintSpace HEIGHT="1416" HPOS="0" VPOS="0" WIDTH="1787">
                            <TextBlock HEIGHT="156" HPOS="98" ID="tr_1" VPOS="14" WIDTH="82">
                              <Shape>
                                <Polygon POINTS="98,14 98,170 180,170 180,14"/>
                              </Shape>
                              <TextLine BASELINE="98,114 125,114 152,117 180,120" HEIGHT="94" HPOS="87" ID="tr_1_tl_1" VPOS="67" WIDTH="90">
                                <String CONTENT="a" HEIGHT="94" HPOS="0" VPOS="67" WIDTH="270"/>
                              </TextLine>
                            </TextBlock>
                            <TextBlock HEIGHT="1021" HPOS="124" ID="tr_2" VPOS="125" WIDTH="1546">
                              <Shape>
                                <Polygon POINTS="124,125 124,1146 1670,1146 1670,125"/>
                              </Shape>
                              <TextLine BASELINE="1026,168 1053,166 1080,166 1107,166 1134,166 1161,164 1188,162 1215,162 1242,162 1269,162 1296,162 1323,166 1350,168 1377,169 1404,170 1431,171 1458,174 1485,176 1512,176 1539,176 1566,178" HEIGHT="115" HPOS="1017" ID="tr_2_tl_1" VPOS="92" WIDTH="545">
                                <String CONTENT="ca" HEIGHT="115" HPOS="972" VPOS="92" WIDTH="273"/>
                                <SP HEIGHT="115" HPOS="1244" VPOS="92" WIDTH="45"/>
                                <String CONTENT="1250" HEIGHT="115" HPOS="1108" VPOS="92" WIDTH="363"/>
                                <SP HEIGHT="115" HPOS="1471" VPOS="92" WIDTH="45"/>
                                <String CONTENT="1270" HEIGHT="115" HPOS="1290" VPOS="92" WIDTH="273"/>
                              </TextLine>
                            </TextBlock>
                          </PrintSpace>
                        </Page>
                      </Layout>
                    </alto>""";

            Alto alto = Alto.builder()
                .xsiSchemaLocation(
                    "http://www.loc.gov/standards/alto/ns-v4# https://www.loc.gov/standards/alto/v4/alto.xsd")
                .Description(Description.builder()
                    .MeasurementUnit(MeasurementUnit.pixel)
                    .sourceImageInformation(SourceImageInformation.builder()
                        .fileName(FileName.builder()
                            .value(
                                "https://doro.uni-rostock.de/api/iiif/image/v2/demel%252Fk0002%252Fphys_0177/full/full/0/default.jpg")
                            .build()) // FileName
                        .addFileIdentifier(FileIdentifier.builder()
                            .value("http://purl.uni-rostock.de/demel/k0002/phys_0177")
                            .build()) // FileIdentifier
                        .build()) // SourceImageInformation
                    .addProcessing(Processing.builder()
                        .ID("IdOcr")
                        .processingDateTime("2024-04-27T17:44:12.116+02:00")
                        .processingStepSettings("textRecognitionModelId:473|lineDetectionModelId:pylaia")
                        .processingSoftware(ProcessingSoftware.builder()
                            .softwareCreator("READ COOP")
                            .softwareName("Transkribus Processing API")
                            .softwareVersion("1.2.0")
                            .applicationDescription("metagrapho API: https://transkribus.eu/processing/v1/openapi.json")
                            .build()) // ProcessingSoftware
                        .build()) // Processing
                    .build()) // Description
                .Layout(Layout.builder()
                    .addPage(Page.builder()
                        .ID("Page1")
                        .PHYSICAL_IMG_NR(1)
                        .HEIGHT(1416f).WIDTH(1787f)
                        .topMargin(PageSpace.builder()
                            .HEIGHT(0f).WIDTH(1787f).VPOS(0f).HPOS(0f)
                            .build()) // TopMargin
                        .lLeftMargin(PageSpace.builder()
                            .HEIGHT(1416f).WIDTH(0f).VPOS(0f).HPOS(0f)
                            .build()) // LeftMargin
                        .rightMargin(PageSpace.builder()
                            .HEIGHT(1416f).WIDTH(0f).VPOS(0f).HPOS(1787f)
                            .build()) // RightMargin
                        .bottomMargin(PageSpace.builder()
                            .HEIGHT(0f).WIDTH(1787f).VPOS(1416f).HPOS(0f)
                            .build()) // BottomMargin
                        .printSpace(PageSpace.builder()
                            .HEIGHT(1416f).WIDTH(1787f).VPOS(0f).HPOS(0f)
                            .addBlock(TextBlock.builder()
                                .ID("tr_1")
                                .HEIGHT(156f).WIDTH(82f).VPOS(14f).HPOS(98f)
                                .Shape(Shape.builder()
                                    .shape(Polygon.builder()
                                        .POINTS(Points.builder()
                                            .value("98,14 98,170 180,170 180,14")
                                            .build()) // Points
                                        .build()) // Polygon
                                    .build()) // Shape
                                .addTextLine(TextLine.builder()
                                    .ID("tr_1_tl_1")
                                    .BASELINE(Points.builder()
                                        .value("98,114 125,114 152,117 180,120")
                                        .build()) // Points
                                    .HEIGHT(94f).WIDTH(90f).VPOS(67f).HPOS(87f)
                                    .addContent(TextlineString.builder()
                                        .HEIGHT(94f).WIDTH(270f).VPOS(67f).HPOS(0f)
                                        .CONTENT("a")
                                        .build()) // TextLineString
                                    .build()) // TextLine
                                .build()) // TextBlock
                            .addBlock(TextBlock.builder()
                                .ID("tr_2")
                                .HEIGHT(1021f).WIDTH(1546f).VPOS(125f).HPOS(124f)
                                .Shape(Shape.builder()
                                    .shape(Polygon.builder()
                                        .POINTS(Points.builder()
                                            .value("124,125 124,1146 1670,1146 1670,125")
                                            .build()) // Points
                                        .build()) // Polygon
                                    .build()) // Shape
                                .addTextLine(TextLine.builder()
                                    .ID("tr_2_tl_1")
                                    .BASELINE(Points.builder()
                                        .value(
                                            "1026,168 1053,166 1080,166 1107,166 1134,166 1161,164 1188,162 1215,162 1242,162 1269,162 1296,162 1323,166 1350,168 1377,169 1404,170 1431,171 1458,174 1485,176 1512,176 1539,176 1566,178")
                                        .build()) // Points
                                    .HEIGHT(115f).WIDTH(545f).VPOS(92f).HPOS(1017f)
                                    .addContent(TextlineString.builder()
                                        .HEIGHT(115f).WIDTH(273f).VPOS(92f).HPOS(972f)
                                        .CONTENT("ca")
                                        .build()) // TextLineString
                                    .addContent(SP.builder()
                                        .HEIGHT(115f).WIDTH(45f).VPOS(92f).HPOS(1244f)
                                        .build()) // SP
                                    .addContent(TextlineString.builder()
                                        .HEIGHT(115f).WIDTH(363f).VPOS(92f).HPOS(1108f)
                                        .CONTENT("1250")
                                        .build()) // TextLineString
                                    .addContent(SP.builder()
                                        .HEIGHT(115f).WIDTH(45f).VPOS(92f).HPOS(1471f)
                                        .build()) // SP
                                    .addContent(TextlineString.builder()
                                        .HEIGHT(115f).WIDTH(273f).VPOS(92f).HPOS(1290f)
                                        .CONTENT("1270")
                                        .build()) // TextLineString
                                    .build()) // TextLine
                                .build()) // TextBlock
                            .build()) // PageSpace
                        .build()) // Page
                    .build()) // Layout
                .build();
            Assert.assertEquals("Test 1 failed", s, Alto4XMLProcessor.getInstance().marshalToString(alto));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2() {
        String s
            = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <alto xmlns="http://www.loc.gov/standards/alto/ns-v4#" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.loc.gov/standards/alto/ns-v4# https://www.loc.gov/standards/alto/v4/alto.xsd">
                  <Layout>
                    <Page HEIGHT="1219" ID="page_0" PHYSICAL_IMG_NR="0" WIDTH="1717">
                      <PrintSpace HEIGHT="1219" HPOS="0" VPOS="0" WIDTH="1717">
                        <ComposedBlock HEIGHT="642" HPOS="108" ID="cblock_0" VPOS="128" WIDTH="1481">
                          <TextBlock HEIGHT="642" HPOS="108" ID="block_0" VPOS="128" WIDTH="1481">
                            <TextLine HEIGHT="43" HPOS="222" ID="line_0" VPOS="128" WIDTH="396">
                              <String CONTENT="/" HEIGHT="26" HPOS="222" ID="string_0" VPOS="140" WC="0.17" WIDTH="26"/>
                              <SP HPOS="248" VPOS="140" WIDTH="82"/>
                              <String CONTENT=":" HEIGHT="2" HPOS="330" ID="string_1" VPOS="128" WC="0.8" WIDTH="6"/>
                              <SP HPOS="336" VPOS="128" WIDTH="269"/>
                              <String CONTENT="." HEIGHT="4" HPOS="605" ID="string_2" VPOS="167" WC="0.34" WIDTH="13"/>
                            </TextLine>
                            <TextLine HEIGHT="71" HPOS="160" ID="line_5" VPOS="651" WIDTH="1366">
                              <String CONTENT="do" HEIGHT="30" HPOS="160" ID="string_31" VPOS="651" WC="0.92" WIDTH="52"/>
                              <SP HPOS="212" VPOS="651" WIDTH="39"/>
                              <String CONTENT="rre" HEIGHT="22" HPOS="1410" ID="string_38" VPOS="699" WC="0.87" WIDTH="100"/>
                              <HYP CONTENT="-" HEIGHT="22" HPOS="1510" VPOS="699" WIDTH="16"/>
                            </TextLine>
                          </TextBlock>
                        </ComposedBlock>
                      </PrintSpace>
                    </Page>
                  </Layout>
                </alto>""";
        try {

            Alto alto = Alto.builder()
                .xsiSchemaLocation(
                    "http://www.loc.gov/standards/alto/ns-v4# https://www.loc.gov/standards/alto/v4/alto.xsd")
                .Layout(Layout.builder()
                    .addPage(Page.builder()
                        .WIDTH(1717f).HEIGHT(1219f)
                        .PHYSICAL_IMG_NR(0)
                        .ID("page_0")
                        .printSpace(PageSpace.builder()
                            .HPOS(0f).VPOS(0f).WIDTH(1717f).HEIGHT(1219f)
                            .addBlock(ComposedBlock.builder()
                                .ID("cblock_0")
                                .HPOS(108f).VPOS(128f).WIDTH(1481f).HEIGHT(642f)
                                .addBlock(TextBlock.builder()
                                    .ID("block_0")
                                    .HPOS(108f).VPOS(128f).WIDTH(1481f).HEIGHT(642f)
                                    .addTextLine(TextLine.builder()
                                        .ID("line_0")
                                        .HPOS(222f).VPOS(128f).WIDTH(396f).HEIGHT(43f)
                                        .addContent(TextlineString.builder()
                                            .ID("string_0")
                                            .HPOS(222f).VPOS(140f).WIDTH(26f).HEIGHT(26f)
                                            .WC(0.17f)
                                            .CONTENT("/")
                                            .build())
                                        .addContent(SP.builder()
                                            .WIDTH(82f).VPOS(140f).HPOS(248f)
                                            .build())
                                        .addContent(TextlineString.builder()
                                            .ID("string_1")
                                            .HPOS(330f).VPOS(128f).WIDTH(6f).HEIGHT(2f)
                                            .WC(0.8f)
                                            .CONTENT(":")
                                            .build())
                                        .addContent(SP.builder()
                                            .WIDTH(269f).VPOS(128f).HPOS(336f)
                                            .build())
                                        .addContent(TextlineString.builder()
                                            .ID("string_2")
                                            .HPOS(605f).VPOS(167f).WIDTH(13f).HEIGHT(4f)
                                            .WC(0.34f)
                                            .CONTENT(".")
                                            .build())
                                        .build()) // TextLine
                                    .addTextLine(TextLine.builder()
                                        .ID("line_5")
                                        .HPOS(160f).VPOS(651f).WIDTH(1366f).HEIGHT(71f)
                                        .addContent(TextlineString.builder()
                                            .ID("string_31")
                                            .HPOS(160f).VPOS(651f).WIDTH(52f).HEIGHT(30f)
                                            .WC(0.92f)
                                            .CONTENT("do")
                                            .build()) // TextLineString
                                        .addContent(SP.builder()
                                            .WIDTH(39f).VPOS(651f).HPOS(212f)
                                            .build()) // SP
                                        .addContent(TextlineString.builder()
                                            .ID("string_38")
                                            .HPOS(1410f).VPOS(699f).WIDTH(100f).HEIGHT(22f)
                                            .WC(0.87f)
                                            .CONTENT("rre")
                                            .build()) // TextLineString
                                        .addContent(HYP.builder()
                                            .HPOS(1510f).VPOS(699f).WIDTH(16f).HEIGHT(22f)
                                            .CONTENT("-")
                                            .build())
                                        .build()) // TextLine
                                    .build()) // TextBlock
                                .build()) // ComposedBlock
                            .build()) // PrintSpace
                        .build()) // Page 
                    .build()) // Layout
                .build();
            Assert.assertEquals("Test 2 failed", s, Alto4XMLProcessor.getInstance().marshalToString(alto));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

}
