const exec = require("cordova/exec");
const argscheck = require("cordova/argscheck");
const LoggerConstants = require("./LoggerConstants");

exports.log = function (options, success, error) {
  if (
    options === null ||
    typeof options !== "object" ||
    Object.prototype.toString.call(options) !== "[object Object]"
  ) {
    return error("Invalid argument! Expected an options object.");
  }

  if (typeof options.message !== "string")
    return error("Invalid argument! Expected type string.");

  const getValue = argscheck.getValue;

  const logType = getValue(options.logType, LoggerConstants.LogType.INFO);
  const tag = getValue(options.tag, LoggerConstants.Tag.DEFAULT);

  const args = [logType, tag, options.message];

  exec(success, error, "Logger", "log", args);
};
