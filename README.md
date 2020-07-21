[![Community Project header](https://github.com/newrelic/opensource-website/raw/master/src/images/categories/Community_Project.png)](https://opensource.newrelic.com/oss-category/#community-project)

# infinite-tracing-protobuf

This project contains the protobuf file needed to generate the gRPC client for communicating with the Trace Observer from the agent.
The generated files are used within the Java Agent to send data to the Trace Observer.

This repo contains:

1. The protobuf files required for communication with the Trace Observer
2. Declared protobuf and gRPC versions

No additional Java code should be contained in this repo.

## Building

To build, run `./gradlew build`

## Support

New Relic has open-sourced this project. This project is provided AS-IS WITHOUT WARRANTY OR DEDICATED SUPPORT. Report issues and contributions to the project here on GitHub.

We encourage you to bring your experiences and questions to the [Explorers Hub](https://discuss.newrelic.com/) where our community members collaborate on solutions and new ideas.

## Community

New Relic hosts and moderates an online forum where customers can interact with New Relic employees as well as other customers to get help and share best practices. Like all official New Relic open source projects, there's a related Community topic in the New Relic Explorers Hub. You can find this project's topic/threads here:

https://discuss.newrelic.com/c/support-products-agents/java-agent

## Contributing
We encourage your contributions to improve this project! Keep in mind when you submit your pull request, you'll need to sign the CLA via the click-through using CLA-Assistant. You only have to sign the CLA one time per project.
If you have any questions, or to execute our corporate CLA, required if your contribution is on behalf of a company,  please drop us an email at opensource@newrelic.com.

## License
This code is licensed under the [Apache 2.0](http://apache.org/licenses/LICENSE-2.0.txt) License.
