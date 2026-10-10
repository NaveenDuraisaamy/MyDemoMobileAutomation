# Velocitor SDET Take-Home — Mobile UI Automation

## Scope
Representative Android UI automation using **Java 17, Appium 2, UiAutomator2, TestNG and Page Object Model**. The assignment asks for valid/invalid login, adding an item and verifying the cart, and a checkout step.

## Architecture
- `DriverManager`: creates and disposes an AndroidDriver per test.
- `BasePage`: explicit waits and common interactions.
- `pages/`: selectors and user-intent actions; tests remain selector-free.
- `tests/`: business-level scenarios.
- `config.properties`: local device/server configuration; system properties/environment variables can override values.

## Why this design
1. POM keeps locators out of test cases.
2. Explicit waits avoid arbitrary sleeps.
3. One driver per test improves isolation.
4. Configuration is externalized so the same suite can run on another emulator/device.
5. Accessibility IDs are preferred because they are generally more stable than XPath. The sample app exposes test IDs/accessibility IDs for interactive elements.

## Prerequisites
- JDK 17+
- Maven 3.9+
- Node.js
- Appium 2+
- UiAutomator2 driver: `appium driver install uiautomator2`
- Android SDK + emulator/device
- Download the Android My Demo App APK from the official Sauce Labs release page and save it as `apps/Android-MyDemoApp.apk` (or override `-DappPath`).

## Run locally
```bash
appium --port 4723
mvn clean test
```

Override device/server:
```bash
mvn clean test -DdeviceName=emulator-5554 -Dudid=emulator-5554 -DappiumServer=http://127.0.0.1:4723
```

## Important selector note
The exact accessibility IDs can differ by My Demo App build. If the downloaded build exposes different IDs, inspect the hierarchy with Appium Inspector and update **only the Page Object classes**; tests do not need to change.

## Cloud evolution
For CI, I would upload the APK to a device cloud and inject `SAUCE_USERNAME` / `SAUCE_ACCESS_KEY` as secrets. A matrix can cover a small set of Android versions/devices. Local emulator execution remains useful for fast PR feedback, while device-cloud runs provide broader compatibility coverage.

## Quality / reliability
- No hard-coded credentials.
- No `Thread.sleep`.
- Test isolation through fresh driver sessions.
- Failure screenshots and structured reporting would be the next enhancement.
- Parallel execution should be enabled only after ensuring test data and devices are isolated.

## AI assistance
AI assistance was used to accelerate scaffolding and documentation. The final structure, selectors, assertions and trade-offs should be reviewed against the actual APK before submission. No MCP-generated code should be represented as manually authored.
