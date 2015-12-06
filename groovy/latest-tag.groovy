
System.getenv().each {
  println it
}

pattern = (['[0-9]' * 2 + '*'] * 3).join "." 
out = "git log --tags=$pattern --pretty=format:%d".execute().text
latest = (out =~ pattern).collect().sort(false) { a, b ->
  [a, b]*.tokenize('.')*.collect { it as int }.with { u, v ->
    [u, v].transpose().findResult{ x, y -> x <=> y ?: null } ?: u.size() <=> v.size()
  }
}[-1]

store = new File('latest-tag.txt')
if (store.exists() && store.text == latest) {
  throw new RuntimeException("No new tags to build")
}

store.text = latest
return [TAG: latest]

