import UIKit
import Cordova


@objc(Logger) class Logger: CDVPlugin {
    @objc(log:)
    func methodName(command: CDVInvokedUrlCommand) {
        let logLevel = command.arguments[0] as? String ?? "info"
        let tag = command.arguments[1] as? String ?? "ESD"
        let message = command.arguments[2] as? String ?? ""

      
        if logLevel == "info" {
            NSLog("[%@] %@", tag, message)
        } else if logLevel == "warn" {
            NSLog("[%@] Warning: %@", tag, message)
        } else if logLevel == "error" {
            NSLog("[%@] Error: %@", tag, message)
        } else {
            NSLog("[%@] Unknown log level: %@. Message:: %@", tag, logLevel ,message)
        }

        sendPluginResultSuccess("Success text", callbackId: command.callbackId)
    }

    private func sendPluginResultSuccess(_ message: String, callbackId: String) {
        let pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAs: message)
        self.commandDelegate.send(pluginResult, callbackId: callbackId)
    }

    private func sendPluginResultError(_ message: String, callbackId: String) {
        let pluginResult = CDVPluginResult(status: CDVCommandStatus_ERROR, messageAs: message)
        self.commandDelegate.send(pluginResult, callbackId: callbackId)
    }
}
