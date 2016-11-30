package com.quantil.thucydides;


import org.junit.runner.RunWith;

import com.quantil.runners.QuantilTestRunner;

import net.thucydides.core.annotations.Feature;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithTag;


public class Features {

	@Feature
    @WithTag("epic:Regression")
    public class Regression {
		public class DeleteTransportTests{}
		public class Bug_2785_Test {} // https://bugzilla.mileweb.com/show_bug.cgi?id=2785
		public class Bug_3207_Test {} // https://bugzilla.mileweb.com/show_bug.cgi?id=3207
		public class Bug_4097_Test {} // https://bugzilla.mileweb.com/show_bug.cgi?id=4097
	}

    @Feature
    @WithTag("epic:Accelerated Lifecycle Management Domain")
    public class WebClassDomainManagement {

        public class QueryDomainTest {}
        public class GetDomainListTest {}
        public class EnableDomainTest {}
        public class DisableDomainTest {}
        public class CancelDomainTest {}
        public class RestoreDomainTest {}
        public class DomainTest {}
    }

    @Feature
    @WithTag("epic:Traffic Related Reporting Services")
    public class TrafficRelatedReportingServices {

        public class AllDomainsTrafficReport {}
        public class RangeFlowReport {}
        public class ReportTest {}
        public class Experiment {}
        public class DTT{}
    }

    @Feature
    @WithTag("epic:Bandwidth Reporting Services")
    public class BandwidthClassReportingServices {

        public class AccelerationDomainBandwidthAllDomainsTest {}
    }

    @Feature
    @WithTag("epic:HDT")
    public class HDT{
        public class TransportManagement{
            public class CreateTransportTests{}
            public class GetTransportTests{}
            public class GetTransportHistoryConfigurationTests{}
            public class DeleteTransportTests{}
            public class ModifyTransportTests{}
            public class ModifyTransportConfigurationTests{}
            public class SearchTransportListTests{}
        }
        public class BasicData{
            public class TransportStrategyListTest{}
            public class TransportTypeListTest{}
        }
        public class FlowData{
            public class TransportTrafficVolumeSummaryReportTest{}
            public class TransportTrafficVolumeReportTest{}
            public class TransportTypeTrafficVolumeReportTest{}
        }
        public class RequestCountData{
            public class RequestCountSummaryReportTest{}
            public class TransportRequestCountReportTest{}
            public class TransportTypeRequestCountReportTest{}
        }

    }
}