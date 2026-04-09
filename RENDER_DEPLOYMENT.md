# Spring Boot Backend - Render Deployment Guide

## 🚀 Quick Start - Deploy Your Existing Backend

Your Spring Boot backend is already configured for Render deployment!

### Step 1: Push to GitHub

If your backend isn't already on GitHub, push it:

```bash
cd workshop-backend
git add .
git commit -m "Update CORS and environment configuration for production"
git push
```

### Step 2: Set Up MySQL Database

**You need a MySQL database** - Choose one:

**Option A: AWS RDS (Recommended)**
1. Go to https://aws.amazon.com/rds/
2. Create MySQL 8.0 instance
3. Note the endpoint, username, and password

**Option B: DigitalOcean Managed MySQL**
1. Go to https://www.digitalocean.com/products/managed-databases/
2. Create MySQL cluster
3. Copy connection credentials

**Option C: Render Managed Databases (When available)**
- Render is adding MySQL support soon

### Step 3: Deploy to Render

1. Go to https://render.com/dashboard
2. Click **"New +"** → **"Web Service"**
3. Connect your **backend repository** (not the frontend repo)
4. Fill in:
   - **Name**: `workshop-backend`
   - **Environment**: Docker
   - **Branch**: main (or your branch)
   - Leave Build/Start commands empty
5. Click **"Advanced"**
6. Add Environment Variables:

| Key | Value | Example |
|-----|-------|---------|
| `SPRING_DATASOURCE_URL` | Your MySQL connection URL | `jdbc:mysql://your-db.xxx.us-east-1.rds.amazonaws.com:3306/workshopdb` |
| `SPRING_DATASOURCE_USERNAME` | Your DB username | `admin` |
| `SPRING_DATASOURCE_PASSWORD` | Your DB password | `YourSecurePassword123!` |
| `PORT` | 8081 | `8081` |

7. Click **"Create Web Service"**

⏳ **Wait 5-10 minutes** for deployment

### Step 4: Get Your Backend URL

Once deployed, Render will give you a URL like:
```
https://workshop-backend.onrender.com
```

### Step 5: Update Frontend API URL

In your **React frontend**, update:

```javascript
// In .env.production
VITE_API_BASE_URL=https://workshop-backend.onrender.com/api
```

### Step 6: Test Connection

```bash
# Test backend is live
curl https://workshop-backend.onrender.com/api/workshops

# Should return: [] or workshop data
```

---

## 📊 Current Endpoints

Your backend already has these working endpoints:

- **Auth**: `POST /api/auth/login`, `POST /api/auth/register`
- **Workshops**: `GET /api/workshops`, `POST /api/workshops`, `PUT /api/workshops/{id}`, `DELETE /api/workshops/{id}`
- **Registration**: `POST /api/registrations`, `GET /api/registrations/{userId}`
- **Contact**: `POST /api/contact-messages`

---

## 🔧 Configuration

### Local Testing (Before Deploying)

```bash
# 1. Update application.properties with your local MySQL
# 2. Run backend
mvn spring-boot:run

# 3. Test endpoints
curl http://localhost:8081/api/workshops
```

### Production Environment Variables

These are automatically read from environment:
- `PORT` - Server port
- `SPRING_DATASOURCE_URL` - Database URL
- `SPRING_DATASOURCE_USERNAME` - DB user
- `SPRING_DATASOURCE_PASSWORD` - DB password

---

## 🐛 Troubleshooting

**Backend won't start**
- Check MySQL database URL is correct
- Verify username/password are right
- Check Render logs for detailed error

**Database connection timeout**
- Ensure security groups/firewall allows access
- Verify database is running
- Check for character encoding issues in URL

**CORS errors from frontend**
- Backend already allows `https://workshop-platform.onrender.com`
- If you're deploying to different frontend URL, update `CrosConfig.java`

**Build fails**
```bash
# Try local build first
mvn clean package -DskipTests
```

---

## 📚 Files Changed

Updated for Render:
- `CrosConfig.java` - Added production URLs
- `application.properties` - Environment variable support
- `Dockerfile` - Port 8081
- `render.yaml` - Render configuration (NEW)
- `Procfile` - Heroku/Render support (NEW)

---

## 🔗 Important Links

- **Render Docs**: https://render.com/docs
- **Spring Boot Docs**: https://spring.io/projects/spring-boot
- **MySQL Connection**: https://dev.mysql.com/doc/connector-j/latest/
- **Docker Reference**: https://docs.docker.com/

---

## ✅ Deployment Checklist

- [ ] Backend code pushed to GitHub
- [ ] MySQL database created (AWS RDS or DigitalOcean)
- [ ] Backend deployed to Render Web Service
- [ ] Backend URL received from Render
- [ ] Frontend `.env.production` updated with backend URL
- [ ] Frontend deployed/updated to use new backend URL
- [ ] API calls working in browser (check Network tab)
- [ ] User registration working
- [ ] Workshops can be created and viewed

---

Need help? Ask your educator or check Render's support docs!
