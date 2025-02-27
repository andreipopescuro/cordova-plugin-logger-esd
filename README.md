# `cordova-plugin-logger-esd`

### This is a simple cordova plugin written in Kotlin and Swift that helps write logs to the device console.

- [Platforms](#platforms)
- [Installation](#installation)
- [Dependencies](#dependencies)
- [Methods](#methods)
- [Reference](#reference)
- [Examples](#examples)

## Platforms

> ## iOS

> ## android

## Dependencies

- `cordova-plugin-add-swift-support@2.0.2` that uses `Swift 4`

- `cordova 12`

- `cordova-ios 7`

- `cordova-android 13`

## Installation

```
cordova plugin add cordova-plugin-logger-esd
```

## Methods

- log

## Reference

### `LoggerConstants.LogType`

| Property | Value                    | Description |
| -------- | ------------------------ | ----------- |
| INFO     | <code>["info"]()</code>  |
| ERROR    | <code>["error"]()</code> |
| WARN     | <code>["warn"]()</code>  |

### `LoggerConstants.Tag`

| Property | Value                  | Description                                   |
| -------- | ---------------------- | --------------------------------------------- |
| DEFAULT  | <code>["ESD"]()</code> | the default tag used in logs to aid filtering |

### `logOptions`

| Property | Type                     | Default                                |
| -------- | ------------------------ | -------------------------------------- |
| logType  | <code>[LogType]()</code> | <code>[LogType.INFO]()</code>          |
| tag      | <code>[Tag]()</code>     | <code>[Tag.DEFAULT]()</code>           |
| message  | <code>[string]()</code>  | ❗` calls onError if not specified` ❗ |

## Examples

| Param   | Type                        |
| ------- | --------------------------- |
| success | <code>[onSuccess]()</code>  |
| error   | <code>[onError]()</code>    |
| options | <code>[logOptions]()</code> |

```js
const logOptions = {
  logType: LoggerConstants.LogType.ERROR,
  tag: "MyApplicationName",
  message: "Your message",
};

function onSuccess() {
  console.log("Message logged successfully");
}

function onError(message) {
  console.log(`Message log failed ${message}`);
}

cordova.plugins.Logger.log(options, onSuccess, onError);
```
