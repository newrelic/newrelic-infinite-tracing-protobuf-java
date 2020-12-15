[![Community Plus header](https://github.com/newrelic/opensource-website/raw/master/src/images/categories/Community_Plus.png)](https://opensource.newrelic.com/oss-category/#community-plus)

# infinite-tracing-protobuf

This project contains the protobuf file needed to generate the gRPC client for communicating with the Trace Observer from the agent.
The generated files are used within the Java Agent to send data to the Trace Observer.

This repo contains:

1. The protobuf files required for communication with the Trace Observer
2. Declared protobuf and gRPC versions

No additional Java code should be contained in this repo.

## Installation

Note: This project is for direct use by the New Relic Java agent and is not intended to be used on its own.

## Getting Started

See instructions on [building](#building) the project. 

## Building

To build, run `./gradlew build`

## Support

Should you need assistance with New Relic products, you are in good hands with several support channels.

If the issue has been confirmed as a bug or is a feature request, file a GitHub issue.

**Support Channels**

* [New Relic Community](https://discuss.newrelic.com/c/support-products-agents/java-agent): The best place to engage in troubleshooting questions
* [New Relic Developer](https://developer.newrelic.com/): Resources for building a custom observability applications
* [New Relic University](https://learn.newrelic.com/): A range of online training for New Relic users of every level
* **[For Community Plus repositories]** [New Relic Technical Support](https://support.newrelic.com/) 24/7/365 ticketed support. Read more about our [Technical Support Offerings](https://docs.newrelic.com/docs/licenses/license-information/general-usage-licenses/support-plan). 

## Privacy

At New Relic we take your privacy and the security of your information seriously, and are committed to protecting your information. We must emphasize the importance of not sharing personal data in public forums, and ask all users to scrub logs and diagnostic information for sensitive information, whether personal, proprietary, or otherwise.

We define “Personal Data” as any information relating to an identified or identifiable individual, including, for example, your name, phone number, post code or zip code, Device ID, IP address, and email address.

For more information, review [New Relic’s General Data Privacy Notice](https://newrelic.com/termsandconditions/privacy).

## Contribute

We encourage your contributions to improve newrelic-infinite-tracing-protobuf-java! Keep in mind that when you submit your pull request, you'll need to sign the CLA via the click-through using CLA-Assistant. You only have to sign the CLA one time per project.

If you have any questions, or to execute our corporate CLA (which is required if your contribution is on behalf of a company), drop us an email at opensource@newrelic.com.

**A note about vulnerabilities**

As noted in our [security policy](../../security/policy), New Relic is committed to the privacy and security of our customers and their data. We believe that providing coordinated disclosure by security researchers and engaging with the security community are important means to achieve our security goals.

If you believe you have found a security vulnerability in this project or any of New Relic's products or websites, we welcome and greatly appreciate you reporting it to New Relic through [HackerOne](https://hackerone.com/newrelic).

If you would like to contribute to this project, review [these guidelines](./CONTRIBUTING.md).

To [all contributors](https://github.com/newrelic/newrelic-infinite-tracing-protobuf-java/graphs/contributors), we thank you!  Without your contribution, this project would not be what it is today.

## License
newrelic-infinite-tracing-protobuf-java is licensed under the [Apache 2.0](http://apache.org/licenses/LICENSE-2.0.txt) License.
