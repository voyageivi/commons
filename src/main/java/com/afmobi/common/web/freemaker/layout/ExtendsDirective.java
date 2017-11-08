package com.afmobi.common.web.freemaker.layout;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * ClassName:   ExtendsDirective
 * Date:        2017-06-23 15:29
 *
 * @author Vincent
 */
public class ExtendsDirective implements TemplateDirectiveModel {

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String layoutName =  ((SimpleScalar)params.get("name")).getAsString();

        processBody(body);
        processLayout(env, layoutName);
    }

    private void processBody(TemplateDirectiveBody body) throws TemplateException, IOException {
        if (body == null) {
            return;
        }

        StringWriter fakeOut = new StringWriter();
        body.render(fakeOut);
    }

    private void processLayout(Environment env, String layoutName) throws IOException, TemplateException {
        env.include(layoutName, null, true);
    }
}
