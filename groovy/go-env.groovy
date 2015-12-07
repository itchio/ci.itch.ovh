
// test variables
WORKSPACE = "WORKSPACE"
os = "linux"
arch = "amd64"
Path = "C:\\windows"
PATH = "/usr/bin"
JENKINS_TAG = "v0.1.3"

env = [
  GOPATH: "$WORKSPACE/../../../..",
  GOARCH: "$arch",
  CGO_ENABLED: 1,
  CC_FOR_TARGET: "gcc",
  CXX_FOR_TARGET: "g++",
]

if (JENKINS_TAG == "**") {
  env.JENKINS_VERSION = "head"
  env.JENKINS_DEPLOY = 0
} else {
  env.JENKINS_VERSION = JENKINS_TAG
  env.JENKINS_DEPLOY = 1
}
env.JENKINS_LDFLAGS = "-X main.version=${env.JENKINS_VERSION}"

switch (os) {
  case "windows":
    winBase = "C:\\msys64\\usr\\bin;C:\\msys64\\usr\\lib\\p7zip"

    switch (arch) {
      case "386":
        env.Path = "$Path;$winBase;C:\\msys64\\mingw32\\bin"
        break
      case "amd64":
        env.Path = "$Path;$winBase;C:\\msys64\\mingw64\\bin"
        break
    }
    break

  default:
    env.PATH = "$PATH:/usr/local/go/bin"
}

env.each { println it }

return env
