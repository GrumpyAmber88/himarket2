# Portal Frontend

API Developer Portal 前台项目，基于 Next.js 15、Tailwind CSS 和 shadcn/ui 构建。

## 功能特性

- 🏠 **首页** - API 市场的宣传页面
- 🔍 **API 市场** - 浏览和搜索 API 卡片
- 👥 **Consumer 管理** - 管理 API 消费者和权限
- 🎨 **现代 UI** - 使用 shadcn/ui 组件库
- 📱 **响应式设计** - 适配各种设备屏幕
- 🌙 **深色模式** - 支持明暗主题切换

## 技术栈

- **框架**: Next.js 15 with App Router
- **样式**: Tailwind CSS 4
- **UI 组件**: shadcn/ui
- **图标**: Lucide React
- **TypeScript**: 5.x
- **开发工具**: ESLint, Turbopack

## 快速开始

### 安装依赖

```bash
npm install
```

### 启动开发服务器

```bash
npm run dev
```

打开 [http://localhost:3000](http://localhost:3000) 查看应用。

### 构建生产版本

```bash
npm run build
npm start
```

## 项目结构

```
portal-frontend/
├── src/
│   ├── app/                    # Next.js App Router
│   │   ├── page.tsx           # 首页
│   │   ├── apis/              # API 市场页面
│   │   ├── consumers/         # Consumer 管理页面
│   │   ├── layout.tsx         # 根布局
│   │   └── globals.css        # 全局样式
│   ├── components/            # React 组件
│   │   ├── ui/                # shadcn/ui 组件
│   │   └── navigation.tsx     # 导航组件
│   └── lib/                   # 工具函数
│       └── utils.ts           # 通用工具
├── public/                    # 静态资源
├── components.json            # shadcn/ui 配置
├── next.config.ts             # Next.js 配置
├── tailwind.config.ts         # Tailwind CSS 配置
└── package.json               # 项目依赖
```

## 页面说明

### 首页 (/)
- 展示 API Dev Portal 的主要信息
- 包含产品介绍和行动号召按钮
- 具有吸引人的视觉设计

### API 市场 (/apis)
- 显示可用的 API 卡片
- 每个卡片包含 API 名称、描述、端点数量等信息
- 支持不同的 HTTP 方法标签

### Consumer 管理 (/consumers)
- 显示消费者列表
- 支持添加新的消费者
- 包含消费者的基本信息和 API 访问权限

## 开发指南

### 添加新页面

1. 在 `src/app/` 目录下创建新的文件夹
2. 添加 `page.tsx` 文件
3. 在导航组件中添加相应链接

### 添加新组件

1. 在 `src/components/` 目录下创建组件文件
2. 使用 shadcn/ui 组件作为基础
3. 遵循项目的设计系统

### 样式定制

项目使用 Tailwind CSS 和 CSS 变量系统，可在 `src/app/globals.css` 中定制主题。

## 相关项目

- [portal-admin](../portal-admin) - 后台管理系统 