# Space Invoices Java SDK (*In progress*)

The Space Invoices Java SDK provides an easy way to access Space Invoices API from Java applications.

## Documentation

**Detailed documentation about the API can be found at [docs.spaceinvoices.com](http://docs.spaceinvoices.com)**

**We also invite you to join our Slack community channel [Space Invaders](http://joinslack.spaceinvoices.com)**

## Gradle

Latest official release:
``` gradle
implementation("si.studio404:space-invoices-java:0.0.1")
```

## Usage

**TOKEN** and **ACCOUNT_ID** can be obtained by signing up for a developer account on our website [spaceinvoices.com](http://spaceinvoices.com)

### Java

Get SpaceInvoices instance
``` java
SpaceInvoices spaceInvoices = new SpaceInvoices(TOKEN);
```

Create new Organization
``` java
CreateOrganizationResponse response = spaceInvoices.createOrganization(
    ACCOUNT_ID,
    Organization.Builder()
        .setName("SpaceX")
        .setCountry("USA")
        .build()
);
```

### Kotlin
``` kt
val spaceInvoices = SpaceInvoices(TOKEN)
```

Create new Organization
``` kt
val response = spaceInvoices.createOrganization(
    accountId = ACCOUNT_ID,
    name = "SpaceX",
    country = "USA"
)
```

Visit our website [spaceinvoices.com](http://spaceinvoices.com)
