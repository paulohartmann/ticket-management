const PROXY_CONFIG = [
  {
      context: [
          "/user"
      ],
      target: "http://localhost:8080",
      secure: false
  }
]

module.exports = PROXY_CONFIG;
