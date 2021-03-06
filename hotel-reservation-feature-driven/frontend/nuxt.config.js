export default {
  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: "hotel-reservation-feature-driven",
    htmlAttrs: {
      lang: "ja"
    },
    meta: [
      { charset: "utf-8" },
      { name: "viewport", content: "width=device-width, initial-scale=1" },
      { hid: "description", name: "description", content: "" },
      { name: "format-detection", content: "telephone=no" }
    ],
    link: [
      { rel: "icon", type: "image/x-icon", href: "/favicon.ico" }
    ]
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [
    "@/assets/css/main.css",
  ],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [
  ],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    // https://go.nuxtjs.dev/typescript
    "@nuxt/typescript-build",
    // https://go.nuxtjs.dev/tailwindcss
    "@nuxtjs/tailwindcss",
    // https://composition-api.nuxtjs.org
    "@nuxtjs/composition-api/module"
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    "@nuxtjs/axios",
    "@nuxtjs/auth-next"
  ],

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {
  },

  // https://axios.nuxtjs.org/options/
  axios: {
    baseURL: "http://localhost:8080/api/i/v0",
  },

  router: {
    middleware: ["auth"]
  },

  auth: {
    redirect: {
      login: "/login",
      logout: "/login",
      home: "/tasks"
    },
    strategies: {
      cookie: {
        token: {
          property: "token",
          global: true,
          required: true,
          type: "Bearer"
        },
        user: {
          property: "user",
          autoFetch: true
        },
        endpoints: {
          login: { url: "/login", method: "post" },
          logout: false,
          user: { url: "/users/auth", method: "get" }
        }
      }
    }
  }
}
