# itch-ci-jobs

This repo contains human-readable, diffable, YAML definitions
for all jobs running at <http://ci.itch.ovh>

We use [jenkins-job-builder](http://docs.openstack.org/infra/jenkins-job-builder)
to generate XML config that Jenkins can grok from these files.

To get started, you need python + pip (one of its package managers). Then,
install with:

```bash
pip install jenkins-job-builder
```

Still learning how JJB works, ping me (@fasterthanlime) if the rest of
instructions aren't there by the time you read this!

