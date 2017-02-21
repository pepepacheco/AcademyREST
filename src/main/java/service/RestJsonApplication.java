/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.sun.jersey.api.core.PackagesResourceConfig;
import javax.ws.rs.ApplicationPath;
 
@ApplicationPath("/")
public class RestJsonApplication extends PackagesResourceConfig {
 
    public RestJsonApplication() {
        super("com.giantflyingsaucer.restjson.v1.resources.impl");
    }
}