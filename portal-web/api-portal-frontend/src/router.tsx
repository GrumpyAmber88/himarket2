import { Routes, Route } from "react-router-dom";
import Apis from "./pages/Apis";
import Models from "./pages/Models.tsx";
import ApiDetail from "./pages/ApiDetail";
import ConsumerDetail from "./pages/ConsumerDetail";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Callback from "./pages/Callback";
import Mcp from "./pages/Mcp";
import McpDetail from "./pages/McpDetail";
import OidcCallback from "./pages/OidcCallback";

export default function Router() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/login" element={<Login />} />
      <Route path="/callback" element={<Callback />} />
      <Route path="/apis" element={<Apis />} />
      <Route path="/apis/:id" element={<ApiDetail />} />
      <Route path="/models/:id" element={<ApiDetail />} />
      <Route path="/models" element={<Models />} />
      <Route path="/mcp" element={<Mcp />} />
      <Route path="/mcp/:mcpName" element={<McpDetail />} />
      <Route path="/consumers/:consumerId" element={<ConsumerDetail />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route path="/profile" element={<Profile />} />
      <Route path="/callback" element={<Callback />} />
      <Route path="/oidc/callback" element={<OidcCallback />} />

      {/* 其他页面可继续添加 */}
    </Routes>
  );
} 