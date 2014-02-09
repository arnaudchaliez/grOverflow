package gameoverflow

import grails.test.GrailsUrlMappingsTestCase

class UrlMappingsTests extends GrailsUrlMappingsTestCase {
    void testUrlMappings() {
        assertForwardUrlMapping("/", controller: 'home', action: "index")
    }
}
