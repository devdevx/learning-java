# Learning java

Project used to learn to use some java libraries

## Commands

View new dependencies versions

```
mvn versions:display-dependency-updates
```

Update dependencies

```
mvn versions:use-latest-releases
```

View new plugin versions

```
mvn versions:display-plugin-updates
```

Check style

```
mvn checkstyle:check@google checkstyle:check@custom
```
```
mvn tidy:check
```

## Configure IDE

### IntelliJ

1. Install checkstyle plugin
2. Configure the plugin to use the google checkstyle and the custom one
