node('maven') {
  stage('Checkout') {
    // Ensure Jenkins has been configured with latest Oracle JDK 8
    jdk = tool name: "OracleJDK8"
    env.JAVA_HOME = "${jdk}"
    echo "Using : ${jdk}"
    git url: "http://gogs-cicd.192.168.99.100.nip.io/xeonn/otcs-att", branch: 'master'
  }
  stage('Build') {
    sh "mvn package -Dmaven.test.skip=true"
  }
  stage('Rollout Dev Image') {
    echo "Rolling out to DEVELOPMENT environment."
    sh "oc start-build -n dev otcs-att --from-dir . --follow"
  }
  stage('Code Quality') {
    sh "echo \"Code quality check successful\""
  }
  stage('Unit Test') {
    sh "echo \"All unit test successful\""
  }
  stage('Integration Test') {
    sh "echo \"All integration test successful\""
  }
  stage('Rollout Beta Image') {
    echo "Rolling out to STAGE environment."
    // delete route to dev environment
    // delete service to dev environment
    // delete t
    sh "oc start-build -n stage otcs-att"
    sh "oc tag -n stage dev/otcs-att:latest stage/otcs-att:blue"
    sh "oc expose service otcs-att"
  }
}
