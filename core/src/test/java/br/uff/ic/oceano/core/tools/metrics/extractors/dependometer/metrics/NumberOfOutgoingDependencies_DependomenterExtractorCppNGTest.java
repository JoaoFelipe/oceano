/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.ic.oceano.core.tools.metrics.extractors.dependometer.metrics;

import br.uff.ic.oceano.core.model.transiente.Language;
import br.uff.ic.oceano.core.tools.metrics.extractors.BaseMetricTest;
import br.uff.ic.oceano.core.tools.metrics.extractors.TestScenario;
import br.uff.ic.oceano.core.tools.metrics.extractors.dependometer.DependomenterExtractor;
import com.valtech.source.dependometer.app.core.common.MetricEnum;
import org.testng.annotations.BeforeClass;

/**
 *
 * @author Daniel
 */
public class NumberOfOutgoingDependencies_DependomenterExtractorCppNGTest extends BaseMetricTest{

    public NumberOfOutgoingDependencies_DependomenterExtractorCppNGTest() {
        super(MetricEnum.NumberOfOutgoingDependencies.name(),Language.CPP,DependomenterExtractor.class);
    }

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();

        addTestScenario(new TestScenario(testConstantsCpp.getEasyCountRevision(),null));
        addTestScenario(new TestScenario(testConstantsCpp.getNeopzRevision(), 0.0));
    }
}
