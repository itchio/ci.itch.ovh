
pattern = "[0-9][0-9]*.[0-9][0-9]*.[0-9][0-9]*"

out = "git log --tags=$pattern --pretty=format:%d".execute().text
versions = (out =~ pattern)
latest = versions.collect().sort(false) { a, b ->
  [a, b]*.tokenize('.')*.collect { it as int }.with { u, v ->
    [u, v].transpose().findResult{ x, y -> x <=> y ?: null } ?: u.size() <=> v.size()
  }
}[-1]

props = "JENKINS_TAG = v$latest"

latest_tag = new File('latest_tag.properties')
revision = new File('revision.properties')

if (latest_tag.exists() && latest_tag.text == props) {
  revision.text = "JENKINS_TAG = **"
} else {
  revision.text = props
}

  latest_tag.text = props
