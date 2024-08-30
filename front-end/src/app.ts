import { renderHome } from "./pages/home.js";
import { renderCandidateProfile } from "./pages/candidateProfile.js";
import { renderCompanyProfile } from "./pages/companyProfile.js";

export function initApp() {
  const appDiv = document.getElementById("app");

  function navigate(path: string) {
    switch (path) {
      case "/candidate":
        renderCandidateProfile(appDiv);
        break;
      case "/company":
        renderCompanyProfile(appDiv);
        break;
      default:
        renderHome(appDiv);
    }
  }

  window.onpopstate = () => navigate(window.location.pathname);

  appDiv?.addEventListener("click", (event) => {
    const target = event.target as HTMLAnchorElement;
    if (target.tagName === "A") {
      event.preventDefault();
      const href = target.getAttribute("href");
      if (href) {
        history.pushState(null, "", href);
        navigate(href);
      }
    }
  });

  navigate(window.location.pathname);
}
