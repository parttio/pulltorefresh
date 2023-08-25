# PullToRefresh add-on project for Vaadin

A Vaadin add-on that implements Java API for [pulltorefresh.js](https://github.com/BoxFactura/pulltorefresh.js) library.

### Development

Starting the test/demo server:
```
mvn jetty:run
```

This deploys demo at http://localhost:8080

### Integration test

TODO add integration tests :-)

## Publishing to Vaadin Directory

With commit rights to the repository, issue:

    mvn release:prepare release:clean

Configured GH action will build a release and push to Maven Central.
