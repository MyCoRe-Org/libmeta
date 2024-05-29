package org.mycore.libmeta.mods.junit5.model._toplevel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mycore.libmeta.mods.MODSXMLProcessor;
import org.mycore.libmeta.mods.model.Mods;
import org.mycore.libmeta.mods.model._toplevel.Subject;
import org.mycore.libmeta.mods.model.subject.SubjectHierarchicalGeographic;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.City;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.Country;
import org.mycore.libmeta.mods.model.subject.hierarchicalgeographic.State;

public class SubjectTest {

    @Test
    public void test1() {
        Country c = new Country();
        c.setContent("Germany");
        State state = new State();
        state.setStateType("bundesland");
        state.setContent("Mecklenburg-Vorpommern");
        City city = new City();
        city.setContent("Rostock");
        Mods mods = Mods.builder()
            .addContent(Subject.builder()
                .addContent(SubjectHierarchicalGeographic.builder()
                    .addContent(c)
                    .addContent(state)
                    .addContent(city)
                    .build())
                .build())
            .build();
        try {
            String s = MODSXMLProcessor.getInstance().marshalToString(mods);
            String expected
                = """
                    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                    <mods:mods xmlns:mods="http://www.loc.gov/mods/v3" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                      <mods:subject>
                        <mods:hierarchicalGeographic>
                          <mods:country>Germany</mods:country>
                          <mods:state stateType="bundesland">Mecklenburg-Vorpommern</mods:state>
                          <mods:city>Rostock</mods:city>
                        </mods:hierarchicalGeographic>
                      </mods:subject>
                    </mods:mods>""";
            assertEquals("Test 1 failed", expected, s);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
