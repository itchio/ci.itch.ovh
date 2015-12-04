# itch-ci-jobs

This repo contains human-readable, diffable, YAML definitions
for all jobs running at <https://lockfree.ch>

We use [cigale](https://github.com/itchio/cigale)
to generate XML config that Jenkins can grok from these files.

To install cigale, clone it, cd into it, then run:

```bash
bundler install
rake install
```

You should be able to run `cigale` now.
