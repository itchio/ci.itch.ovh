# ci.itch.ovh

![needs more badges](https://img.shields.io/badge/CI%20/%20CD-pretty%20cool-FFC107.svg)

This repo contains human-readable, diffable, YAML definitions
for all jobs running at <https://ci.itch.ovh>

We use [cigale](https://github.com/itchio/cigale)
to generate XML config that Jenkins can grok from these files.

To install cigale, make sure you have ruby & rubygems installed, and run:

```bash
gem install cigale
```

You should be able to run `cigale` now.

**Note: cigale 0.4.1 or higher is required**

## Testing config files

To test your changes, run:

```bash
cigale test src -o tmp
```

It'll output a bunch of `.xml` files in `tmp/` that you can compare with
Jenkins-generated files (e.g. `/var/lib/jenkins/jobs/foobar/config.xml`)

If you're suspecting macros and the XML output isn't clear enough,
use the `dump` command to dump YAML after all macros have been expanded

```bash
cigale dump src -o tmp
```

## Updating Jenkins config

First off, copy `secret/cigale.sample.yml` to `secret/cigale.yml` and
edit in your actual credentials.

**Don't actually put your password**, use your Jenkins API key, which
you can find at <https://ci.itch.ovh/user/YOUR_JENKINS_USERNAME/configure>

Then run:

```bash
cigale update src
```

That command creates or updates all jobs defined in `src/**/*.yml`

If you've renamed some jobs, rename them from the Jenkins UI before running
`cigale update`.

