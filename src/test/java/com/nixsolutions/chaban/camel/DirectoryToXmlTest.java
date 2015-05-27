package com.nixsolutions.chaban.camel;

import org.custommonkey.xmlunit.XMLTestCase;
import org.junit.Test;
import org.xml.sax.InputSource;

import java.io.FileInputStream;

/**
 * Created by chaban on 25.05.15.
 */
public class DirectoryToXmlTest extends XMLTestCase {
    String expected = ("expected.xml");
    String actual = ("./target/actual.xml");

    @Test
    public void test() throws Exception {
        DirectoryToXml transformer = new DirectoryToXml();
        transformer.run("./", "./target/actual.xml");
        assertXMLEqual(new InputSource(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream(expected)),
                new InputSource(new FileInputStream(actual)));
    }
}
